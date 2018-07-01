package com.mzw.mytoolbar;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String DOG_BREEDS[] = {"第一页", "第二页", "第三页", "第四页"};
    private ViewPager viewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(viewPager);
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return new PageFragment(i);
        }

        @Override
        public int getCount() {
            return DOG_BREEDS.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return DOG_BREEDS[position];
        }
    }

    public static class PageFragment extends Fragment {
        int position = 0;
        public PageFragment() {
        }

        @SuppressLint("ValidFragment")
        public PageFragment(int i) {
            position = i;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_page, container, false);
            TextView tv = view.findViewById(R.id.textView);
            tv.setText(DOG_BREEDS[position] + "");
            return view;
        }
    }
}
