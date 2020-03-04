package com.pckosek.interfaceargumentviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InterfaceArgumentFragment.MyFragmentInterface {

    ViewPager mViewPager;
    TextView mTextView;
    MyViewPagerAdapter mMyViewPagerAdapter;
    String[] labels = {"Zero", "One", "Two", "Three", "Four", "Five", "HAHAHAHAHA" };

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
    public void onFragmentInteraction(int i) {
        mTextView.setText( "Called From Fragment: " + i);
    }

    public class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return InterfaceArgumentFragment.newInstance(
                    position,
                    labels[position]);
        }

        @Override
        public int getCount() {
            return labels.length;
        }
    }
}