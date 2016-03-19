package kookmin.ac.kr.kook_bab.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

import kookmin.ac.kr.kook_bab.Fragment.SearchFragment;
import kookmin.ac.kr.kook_bab.Fragment.InSchoolFragment;
import kookmin.ac.kr.kook_bab.Fragment.OtherInfoFragment;
import kookmin.ac.kr.kook_bab.Fragment.OutSchoolFragment;
import kookmin.ac.kr.kook_bab.Other.Data;
import kookmin.ac.kr.kook_bab.R;



public class MainActivity extends FragmentActivity {
    private static final String[] CONTENT = new String[] { "교내", "교외", "검색", "기타" };
    private static final int[] ICONS = new int[] {
            R.drawable.kmu,
            R.drawable.fork,
            R.drawable.places_ic_search,
            R.drawable.perm_group_device_alarms,
    };
    Intent splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splash = new Intent(this, Data.class);
        // Splash(로딩화명) 띄우기
        startActivity(splash);

        //Viewpageindicator Setting
        FragmentPagerAdapter adapter = new MyAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }

    class MyAdapter extends FragmentPagerAdapter implements IconPagerAdapter{
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //Fragment Setting
        @Override
        public Fragment getItem(int position) {
            if(position == 1) {
                OutSchoolFragment out = new OutSchoolFragment();
                return out;
            }
            else if(position == 2){
                SearchFragment del = new SearchFragment();
                return del;
            }
            else if(position == 3) {
                OtherInfoFragment other = new OtherInfoFragment();
                return other;
            }
            else {
                InSchoolFragment in = new InSchoolFragment();
                return in;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override public int getIconResId(int index) {
            return ICONS[index];
        }


        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }
}