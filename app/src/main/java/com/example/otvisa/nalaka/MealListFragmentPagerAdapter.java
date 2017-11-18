package com.example.otvisa.nalaka;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by otvisa on 11.9.2017.
 */

public class MealListFragmentPagerAdapter extends FragmentStatePagerAdapter {

    public MealListFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return Restaurant.values().length;
    }

    @Override
    public Fragment getItem(int position) {
        return MealListFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Restaurant.values()[position].getName();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
