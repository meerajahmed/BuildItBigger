package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by mahme4 on 12/5/2016.
 */

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest {
    @Test
    public void getJoke() {
        new JokeAsyncTask(new JokeAsyncTask.JokeListener() {
            @Override
            public void onJokeLoad(String joke) {
                assertNotNull(joke);
            }
        }).execute();
    }
}
