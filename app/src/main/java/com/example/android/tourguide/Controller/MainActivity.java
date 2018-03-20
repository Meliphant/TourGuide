package com.example.android.tourguide.Controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.android.tourguide.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Moscow Tour Guide");

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        mPager = findViewById(R.id.view_pager);
        PagerAdapter mPageAdapter = new FragmentAdapter(getSupportFragmentManager(), MainActivity.this);
        mPager.setAdapter(mPageAdapter);

        TabLayout mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mPager);

    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_wiki:
                                openWebPage("https://en.wikipedia.org/wiki/Moscow");
                                break;
                            case R.id.navigation_flights:
                                openWebPage("https://www.google.ru/flights/");
                                break;
                            case R.id.navigation_trains:
                                openWebPage("https://pass.rzd.ru/main-pass/public/en");
                                break;
                            case R.id.navigation_living:
                                openWebPage("https://ostrovok.ru/hotel/russia/moscow/#form=true/");
                                break;
                        }
                        return true;
                    }
                });
    }

    private void openWebPage(String url) {
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browse);
    }
}
