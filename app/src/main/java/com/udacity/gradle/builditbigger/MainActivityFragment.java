package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.libjokeandroid.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button tellJokeBtn = (Button) root.findViewById(R.id.tell_joke_btn);
        tellJokeBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new JokeAsyncTask( new JokeAsyncTask.JokeListener(){
                    @Override
                    public void onJokeLoad(String joke) {
                        Intent intent = new Intent(getContext(), JokeActivity.class);
                        intent.putExtra(JokeActivity.INTENT_EXTRA, joke);
                        getContext().startActivity(intent);
                    }
                }).execute();
            }
        });
        return root;
    }

}
