package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TrueFalseFragment extends Fragment implements View.OnClickListener{

    private final static String TAG = "FROM_FRAGMENT";

    private static final String ARG_QUESTION_STRING = "param1";
    private Question mQuestion;

    TrueFalseFragmentInterface mCallback;

    public TrueFalseFragment() {
        // Required empty public constructor
    }

    // newInstance IS THE WAY THE CONSTRUCTOR IS CALLED
    public static TrueFalseFragment newInstance(String param) {
        TrueFalseFragment fragment = new TrueFalseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION_STRING, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCallback = (TrueFalseFragmentInterface) context;
    }

    // ONCREATE IS ARGUMENT PARSER
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            // get the string out of the arguments
            String s = getArguments().getString(ARG_QUESTION_STRING);

            // convert the string into an object
            Gson gson = new GsonBuilder().create();
            mQuestion = gson.fromJson(s, Question.class);
        }
    }

    // ONCREATEVIEW IS LAYOUT INFLATER
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_true_false, container, false);
    }

    //ONVIEWCREATED
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Assign button callbacks
        RadioButton rbTrue  = view.findViewById(R.id.radio_true);
        RadioButton rbFalse = view.findViewById(R.id.radio_false);
        rbTrue.setOnClickListener(this);
        rbFalse.setOnClickListener(this);

        // populate question
        TextView tvQuestion = view.findViewById(R.id.tvQuestion);
        tvQuestion.setText(mQuestion.question);
    }


    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        boolean choice, result;

        switch (v.getId()) {
            case R.id.radio_true:
                if (checked) {
                    choice = true;
                    result = mQuestion.checkAnswer(choice);
                    mCallback.onTrueFalseFragment(result);
                    break;
                }
            case R.id.radio_false:
                if (checked) {
                    choice = false;
                    result = mQuestion.checkAnswer(choice);
                    mCallback.onTrueFalseFragment(result);
                    break;
                }
        }
    }

    public interface TrueFalseFragmentInterface {
        void onTrueFalseFragment(boolean b);
    }
}