package com.pckosek.argumentviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    ViewPager mViewPager;
    MyViewPagerAdapter mMyViewPagerAdapter;
    String[] labels = {"hello", "hi", "hey there", "yo", "what\'s up"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.container);

        mMyViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyViewPagerAdapter);
    }

    public class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return ArgumentFragment.newInstance(labels[position]);
        }

        @Override
        public int getCount() {
            return labels.length;
        }
    }
}