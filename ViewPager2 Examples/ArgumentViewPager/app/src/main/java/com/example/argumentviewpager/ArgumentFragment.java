package com.example.argumentviewpager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ArgumentFragment extends Fragment {

    private static final String KEY_PARAM_01 = "key_for_first_parameter";

    private int mPositionNumber;
    private Button mButton;

    public ArgumentFragment() {
        // Required empty public constructor
    }

    public static ArgumentFragment newInstance(int param1) {
        ArgumentFragment fragment = new ArgumentFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_PARAM_01, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // The class member variable gets assigned in oncreate
            // by parsing out the argument
            mPositionNumber = getArguments().getInt(KEY_PARAM_01);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_argument, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mButton = view.findViewById(R.id.button_pressme);
        mButton.setText( String.valueOf(mPositionNumber));
    }
}