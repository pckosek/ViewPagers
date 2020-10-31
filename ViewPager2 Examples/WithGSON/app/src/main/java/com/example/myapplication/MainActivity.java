package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements TrueFalseFragment.TrueFalseFragmentInterface {

    private final static String TAG = "FROM_MAIN_ACTIVITY";

    ViewPager2 mViewPager;
    MyViewPagerAdapter mMyViewPagerAdapter;
    ArrayList<Question> mQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creat and assign adapter
        mViewPager = findViewById(R.id.container);
        mMyViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewPager.setAdapter(mMyViewPagerAdapter);

        // load questions from string resoureces
        String questions = getResources().getString(R.string.questions);

        // convert strings to objects
        Gson gson = new GsonBuilder().create();
        Question[] qs = gson.fromJson(questions, Question[].class);

        // convert object into an arraylist of questions
        mQuestions = new ArrayList<Question>(Arrays.asList(qs));

    }

    @Override
    public void onTrueFalseFragment() {

    }

    private class MyViewPagerAdapter extends FragmentStateAdapter {

        public MyViewPagerAdapter(MainActivity ma) {
            super(ma);
        }

        @Override
        public Fragment createFragment(int position)
        {
            // convert the question object at this position in to a string
            Gson gson = new GsonBuilder().create();
            String thisQuestion = gson.toJson(mQuestions.get(position));

            // pass the object to a new fragment as a string
            return TrueFalseFragment.newInstance(thisQuestion);
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }
}