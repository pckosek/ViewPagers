package com.pckosek.viewpager2setposition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

        mViewPager.setUserInputEnabled(false);

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0, false);
            }
        });

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2, false);
            }
        });
    }


    private class MyViewPagerAdapter extends FragmentStateAdapter {

        public MyViewPagerAdapter(MainActivity ma) {
            super(ma);
        }

        @Override
        public Fragment createFragment(int position) {
            Fragment res = null;
            switch (position) {
                case 0:
                    res = RulesFragment.newInstance();
                    break;
                case 1:
                    res = QuestionFragment.newInstance("BOO-YA");
                    break;
                default:
                    res = RulesFragment.newInstance();
                    break;
            }
            return res;
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
}
