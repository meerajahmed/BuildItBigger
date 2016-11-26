package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LauncherApps;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.example.android.libjokeandroid.JokeActivity;
import com.example.mahme4.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import static android.R.attr.start;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by mahme4 on 11/22/2016.
 */

public class JokeAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private final String LOG_TAG = JokeAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;
    private Context context;
    private JokeListener jokeListener;

    public JokeAsyncTask(JokeListener listener){
        jokeListener = listener;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        String joke;

        try {
            joke = myApiService.sayJoke().execute().getData();
            Log.v(LOG_TAG, joke);
            return joke;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        jokeListener.onJokeLoad(result);
    }

    public interface JokeListener {
        void onJokeLoad(String joke);
    }

}
