package com.pckosek.argumentviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ArgumentFragment extends Fragment {

    private static final String STRING_KEY = "some_string";
    Button mButton;

    public ArgumentFragment() {
        // Required empty public constructor
    }

    public static ArgumentFragment newInstance(String arg) {
        ArgumentFragment fragment = new ArgumentFragment();

        Bundle args = new Bundle();
        args.putString(STRING_KEY, arg);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_argument, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // assign callbacks, etc
        super.onViewCreated(view, savedInstanceState);

        String arg_value = getArguments().getString(STRING_KEY,"");

        mButton = view.findViewById(R.id.button_pressme);
        mButton.setText(arg_value);
    }
}