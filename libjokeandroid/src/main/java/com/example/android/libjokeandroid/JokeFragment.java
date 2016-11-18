package com.example.android.libjokeandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link JokeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JokeFragment extends Fragment {

    private static final String ARG_JOKE = "com.example.android.libjokeandroid.Fragment.ARG_JOKE";

    private String mJoke;

    public JokeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param joke - joke in string.
     * @return A new instance of fragment JokeFragment.
     */

    public static JokeFragment newInstance(String joke) {
        JokeFragment fragment = new JokeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_JOKE, joke);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mJoke = getArguments().getString(ARG_JOKE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text_joke);
        textView.setText(mJoke);
        return view;

    }

}
