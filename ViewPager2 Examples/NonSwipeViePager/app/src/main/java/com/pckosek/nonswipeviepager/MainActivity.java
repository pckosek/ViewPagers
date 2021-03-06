package com.pckosek.nonswipeviepager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    ViewPager2 mViewPager;
    MyViewPagerAdapter mMyViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign the instance of ViewPager2
        mViewPager = findViewById(R.id.container);
        mMyViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewPager.setAdapter(mMyViewPagerAdapter);

//        mViewPager.setUserInputEnabled(false);



    }

    private class MyViewPagerAdapter extends FragmentStateAdapter {

        public MyViewPagerAdapter(MainActivity ma) {
            super(ma);
        }

        @Override
        public Fragment createFragment(int position)
        {
            return FragmentMain.newInstance();
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }
}
