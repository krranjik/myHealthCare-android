package com.example.myhealthcare.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myhealthcare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private SettingsFragment settingsFragment;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        drawerLayout = findViewById(R.id.drawlayout);
        NavigationView navigationView = findViewById(R.id.menu_nav);
        ImageButton menubutton = findViewById(R.id.menubar);

        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout.setDrawerListener(drawerToggle);
        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer();
            }
        });

        homeFragment = new HomeFragment();
        notificationFragment = new NotificationFragment();
        settingsFragment = new SettingsFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_notification:
                        setFragment(notificationFragment);
                        return true;

                    case R.id.nav_settings:
                        setFragment(settingsFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    private void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.menu_prescription:
                Toast.makeText(this, "Prescription", Toast.LENGTH_SHORT).show();
                return true;
        }

        switch (menuItem.getItemId()){
            case R.id.menu_appointment:
                Toast.makeText(this, "Appointment", Toast.LENGTH_SHORT).show();
                return true;
        }

        switch (menuItem.getItemId()){
            case R.id.menu_report:
                Toast.makeText(this, "Report", Toast.LENGTH_SHORT).show();
                return true;
        }

        switch (menuItem.getItemId()){
            case R.id.menu_doctor:
                Toast.makeText(this, "Doctor", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
