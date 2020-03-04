package com.pckosek.interfaceviewpager;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InterfaceFragment extends Fragment {

    Button mButton;
    MyFragmentInterface mCallback;

    public InterfaceFragment() {
        // Required empty public constructor
    }

    public static InterfaceFragment newInstance() {
        InterfaceFragment fragment = new InterfaceFragment();
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
        return inflater.inflate(R.layout.fragment_interface, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // assign callbacks, etc
        super.onViewCreated(view, savedInstanceState);

        mButton = view.findViewById(R.id.button_pressme);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onFragmentInteraction();
            }
        });
    }

    public interface MyFragmentInterface {
        void onFragmentInteraction();
    }

}