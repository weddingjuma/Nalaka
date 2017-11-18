package com.example.otvisa.nalaka;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        ViewPager viewPager = findViewById(R.id.viewpager);
        MealListFragmentPagerAdapter mlfpa = new MealListFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mlfpa);
        tabLayout.setupWithViewPager(viewPager);
    }
}
