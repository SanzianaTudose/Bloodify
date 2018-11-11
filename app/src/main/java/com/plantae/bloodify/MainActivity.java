package com.plantae.bloodify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.plantae.bloodify.NavigationFragments.EventsFragment;
import com.plantae.bloodify.NavigationFragments.HomeFragment;
import com.plantae.bloodify.NavigationFragments.InfoFragment;
import com.plantae.bloodify.NavigationFragments.LeaderboardFragment;
import com.plantae.bloodify.ToolbarActivities.BenefitsActivity;
import com.plantae.bloodify.ToolbarActivities.LostObjectsActivity;
import com.plantae.bloodify.ToolbarActivities.SettingsActivity;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_leaderboard:
                    fragment = new LeaderboardFragment();
                    break;
                case R.id.navigation_events:
                    fragment = new EventsFragment();
                    break;
                case R.id.navigation_info:
                    fragment = new InfoFragment();
                    break;
            }

            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    // Inflates the menu and adds items to the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    // Defines onClick behaviour for MenuItems
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;

        switch (item.getItemId()) {
            case R.id.benefits:
                intent = new Intent(this, BenefitsActivity.class);
                break;
            case R.id.lost_objects:
                intent = new Intent(this, LostObjectsActivity.class);
                break;
            case R.id.settings:
                intent = new Intent(this, SettingsActivity.class);
                break;
        }
        startActivity(intent);

        return true;
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void launchBloodDetailsActivity(View view) {
        Intent intent = new Intent(this, BloodDetailsActivity.class);
        startActivity(intent);
    }
}
