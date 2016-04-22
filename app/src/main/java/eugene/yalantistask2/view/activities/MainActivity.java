/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eugene.yalantistask2.view.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.melnykov.fab.FloatingActionButton;

import eugene.yalantistask2.R;
import eugene.yalantistask2.presenter.MainPresenter;
import eugene.yalantistask2.utils.listeners.FloatActionButtonOnClickListener;
import eugene.yalantistask2.utils.listeners.NavigationItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FloatingActionButton mFloatingActionButton;

    private MainPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach activity to presenter
        mPresenter = new MainPresenter(this);

        // Init above fields
        initializeComponent();

        // Setup a toolbar
        setSupportActionBar(mToolbar);

        // Setup adapter to ViewPager with fragment to be shown on the screen
        mViewPager.setAdapter(mPresenter.getViewPagerAdapter());

        // Set onClick listener to Float Action Bar
        mFloatingActionButton.setOnClickListener(
                new FloatActionButtonOnClickListener());

        // Setup TabLayout with ViewPager
        mTabLayout.setupWithViewPager(mViewPager);

        // Add DrawerListener to DrawerLayout
        mDrawerLayout.addDrawerListener(
                mPresenter.createActionBarDrawerToggle(mDrawerLayout, mToolbar));

        // Setup NavigationItemSelectedListener to a NavigationView
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationItemSelectedListener(mDrawerLayout));
    }

    /**
     * Initialize all necessary fields from xml layout
     */
    private void initializeComponent() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Detach presenter before onDestroy().
     */
    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
