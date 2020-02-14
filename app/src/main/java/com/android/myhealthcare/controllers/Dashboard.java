package com.android.myhealthcare.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.myhealthcare.R;
import com.android.myhealthcare.api.UserAPI;
import com.android.myhealthcare.helper.GetImage;
import com.android.myhealthcare.helper.UserSession;
import com.android.myhealthcare.models.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private WebviewFragment webviewFragment;
    private SettingsFragment settingsFragment;
    SensorManager mySensorManager;
    Sensor myProximitySensor;
    TextView ProximitySensor;

    CircleImageView profile;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    TextView headername, headeremail;
    CircleImageView imageView;

    UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        profile = findViewById(R.id.profile_image);
        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        drawerLayout = findViewById(R.id.drawlayout);
        NavigationView navigationView = findViewById(R.id.menu_nav);
        ImageButton menubutton = findViewById(R.id.menubar);
        headername = navigationView.getHeaderView(0).findViewById(R.id.headername);
        headeremail = navigationView.getHeaderView(0).findViewById(R.id.headeremail);
        imageView = navigationView.getHeaderView(0).findViewById(R.id.profileimg);
        ProximitySensor = findViewById(R.id.proximityvalue);

        mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null) {
            ProximitySensor.setText("No Proximity Sensor!");
        } else {
            mySensorManager.registerListener(sensorEventListener, myProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, Profile.class));
            }
        });

        UserAPI userAPI = new UserAPI();
        userSession = new UserSession(this);
        String id = userSession.getID();
        User user = userAPI.getPatientDetail(id);

        headername.setText(user.getName());
        headeremail.setText(user.getEmail());
        GetImage.setImage(user.getImage(), imageView);

        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout.setDrawerListener(drawerToggle);
        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer();
            }
        });

        homeFragment = new HomeFragment();
        webviewFragment = new WebviewFragment();
        settingsFragment = new SettingsFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_webview:
                        setFragment(webviewFragment);
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

    SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            WindowManager.LayoutParams params = Dashboard.this.getWindow().getAttributes();
            if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {

                if (event.values[0] == 0) {
                    params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                    params.screenBrightness = 0;
                    getWindow().setAttributes(params);
                } else {
                    params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                    params.screenBrightness = -1f;
                    getWindow().setAttributes(params);
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

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

        switch (menuItem.getItemId()) {
            case R.id.menu_prescription:
                Intent intent = new Intent(Dashboard.this, Prescription.class);
                startActivity(intent);
                return true;
        }

        switch (menuItem.getItemId()) {
            case R.id.menu_appointment:
                Intent intent = new Intent(Dashboard.this, Appointment.class);
                startActivity(intent);
                return true;
        }

        switch (menuItem.getItemId()) {
            case R.id.menu_report:
                Intent intent = new Intent(Dashboard.this, Report.class);
                startActivity(intent);
                return true;
        }

        switch (menuItem.getItemId()) {
            case R.id.menu_doctor:
                Intent intent = new Intent(Dashboard.this, Doctor.class);
                startActivity(intent);
                return true;
        }

        switch (menuItem.getItemId()) {
            case R.id.menu_logout:
                userSession.endSession();
                startActivity(new Intent(Dashboard.this, LoginPage.class));
                return true;
        }

        switch (menuItem.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(Dashboard.this, About.class));
                return true;
        }
        return false;
    }
}
