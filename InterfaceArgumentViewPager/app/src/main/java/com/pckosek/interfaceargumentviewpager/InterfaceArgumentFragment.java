package com.pckosek.interfaceargumentviewpager;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InterfaceArgumentFragment extends Fragment {

    private static final String STRING_KEY = "some_string";
    private static final String INT_KEY = "some_int";
    Button mButton;
    MyFragmentInterface mCallback;

    public InterfaceArgumentFragment() {
        // Required empty public constructor
    }

    public static InterfaceArgumentFragment newInstance(int arg1, String arg2) {
        InterfaceArgumentFragment fragment = new InterfaceArgumentFragment();

        Bundle args = new Bundle();
        args.putInt(INT_KEY, arg1);
        args.putString(STRING_KEY, arg2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (MyFragmentInterface) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_interface_argument, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // assign callbacks, etc
        super.onViewCreated(view, savedInstanceState);

        mButton = view.findViewById(R.id.button_pressme);
        mButton.setText(getArguments().getString(STRING_KEY,""));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getArguments().getInt(INT_KEY, 0);
                mCallback.onFragmentInteraction(position);
            }
        });
    }

    public interface MyFragmentInterface {
        void onFragmentInteraction(int i);
    }
}