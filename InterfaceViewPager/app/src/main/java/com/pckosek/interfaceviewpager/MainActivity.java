package com.pckosek.interfaceviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InterfaceFragment.MyFragmentInterface {

    ViewPager mViewPager;
    TextView mTextView;
    MyViewPagerAdapter mMyViewPagerAdapter;
    int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.container);

        mMyViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyViewPagerAdapter);

        mTextView = findViewById(R.id.tv_main);
    }

    @Override
    public void onFragmentInteraction() {
        mTextView.setText( "Current Count: " +mCount++);
    }

    public class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return InterfaceFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}