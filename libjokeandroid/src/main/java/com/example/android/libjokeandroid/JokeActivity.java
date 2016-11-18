package com.example.android.libjokeandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class JokeActivity extends AppCompatActivity {

    public static final String LOG_TAG = JokeActivity.class.getSimpleName();
    public static final String INTENT_EXTRA = "com.example.android.libjokeandroid.JokeActivity.INTENT_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        if (savedInstanceState == null) {
            Log.v(LOG_TAG, getIntent().getStringExtra(JokeActivity.INTENT_EXTRA));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_joke, JokeFragment.newInstance(getIntent().getStringExtra(JokeActivity.INTENT_EXTRA)))
                    .commit();
        }
    }
}
