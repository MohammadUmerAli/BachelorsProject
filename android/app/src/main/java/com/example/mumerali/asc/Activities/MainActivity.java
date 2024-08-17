package com.example.mumerali.asc.Activities;

import android.os.Bundle;
import com.example.mumerali.asc.Fragments.AboutApp;
import com.example.mumerali.asc.Fragments.AboutCollege;
import com.example.mumerali.asc.Fragments.Courses;
import com.example.mumerali.asc.Fragments.Maps;
import com.example.mumerali.asc.Fragments.News;
import com.example.mumerali.asc.Fragments.People;
import com.example.mumerali.asc.R;
import com.example.mumerali.asc.Fragments.Syllabus;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new News()).commit();
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

        if (id == R.id.nav_syllabus) {
            // Handle the camera action
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new Syllabus()).commit();
        }

        if (id == R.id.nav_faculty) {
            // Handle the camera action
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new People()).commit();
        }
        if (id == R.id.nav_map) {
            // Handle the camera action
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new Maps()).commit();
        }
        if (id == R.id.nav_courses) {
            // Handle the camera action
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new Courses()).commit();
        }
        if (id == R.id.nav_aboutcollege) {
            // Handle the camera action
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new AboutCollege()).commit();
        }
        if (id == R.id.nav_news) {
            // Handle the camera action
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new News()).commit();
        }
        if (id == R.id.nav_aboutapp) {
            // Handle the camera action
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new AboutApp()).commit();
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
    }
}
