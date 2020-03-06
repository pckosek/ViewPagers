package com.pckosek.viewpager2setposition;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuestionFragment extends Fragment {

    private static final String STRING_KEY = "some_string";
    Button mButton;

    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance(String arg1) {
        QuestionFragment fragment = new QuestionFragment();

        Bundle args = new Bundle();
        args.putString(STRING_KEY, arg1);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // assign callbacks, etc
        super.onViewCreated(view, savedInstanceState);

        String buttonText = getArguments().getString(STRING_KEY);

        mButton = view.findViewById(R.id.button_pressme);
        mButton.setText(buttonText);

    }}
