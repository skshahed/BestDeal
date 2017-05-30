package com.example.forever.bestdeal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.forever.bestdeal.Notification.NotificationFragment;
import com.example.forever.bestdeal.PostProduct.ProductPostFragment;
import com.example.forever.bestdeal.ProductCategories.CategoriesFragment;
import com.example.forever.bestdeal.ProductViewer.ProductFragment;
import com.example.forever.bestdeal.ProductViewer.dummy.DummyContent;
import com.example.forever.bestdeal.UserProfile.ProfileFragment;

public class MainActivity extends AppCompatActivity
        implements ProductFragment.OnListFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       // navigationView.setItemIconTintList(null);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft  =   fm.beginTransaction();
        ProfileFragment productListFragment  = new ProfileFragment();
        ft.add(R.id.fragmentContainer,productListFragment);
        ft.addToBackStack(null);
        ft.commit();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_product_home) {
            fragment= new ProductFragment();

        } else if (id == R.id.nav_product_post) {
            fragment = new ProductPostFragment();

        }else if (id == R.id.nav_my_profile){
            fragment= new ProfileFragment();
        }
        else if (id == R.id.nav_my_product) {
            fragment = new ProductPostFragment();

        } else if (id == R.id.nav_notification) {
            fragment = new NotificationFragment();

        } else if (id == R.id.nav_categories) {
            fragment = new CategoriesFragment();

        } else if (id == R.id.nav_my_favorite) {
            fragment = new ProductPostFragment();

        }


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft  =   fm.beginTransaction();
        ft.replace(R.id.fragmentContainer,fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
