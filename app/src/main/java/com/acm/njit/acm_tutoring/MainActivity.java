package com.acm.njit.acm_tutoring;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
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

        FragmentManager manager = getSupportFragmentManager();
        int id = item.getItemId();
        boolean changed = false;
        FragmentTransaction t=null;

        switch (id)
        {
            case R.id.nav_first_layout:
                t = manager.beginTransaction();
                t.replace(R.id.content_frame , new MainPage());
                changed = true;
                break;
            case R.id.nav_second_layout:
                t = manager.beginTransaction();
                t.replace(R.id.content_frame , new Sigs());
                changed = true;
                break;
            case R.id.nav_third_layout:
                t = manager.beginTransaction();
                t.replace(R.id.content_frame , new Tutoring());
                changed = true;
                break;
            case R.id.nav_fourth_layout:
                t = manager.beginTransaction();
                t.replace(R.id.content_frame , new SocialMedia());
                changed = true;
                break;
            case R.id.nav_send:
                String[] email = new String[1];
                email[0]= "njitacm@gmail.com";
                composeEmail(email);
                break;
        }

        if (changed && t != null){
            t.addToBackStack(null);
            t.commit();
        }

        manager.beginTransaction().commit();

        /*if (id == R.id.nav_first_layout) {
            manager.beginTransaction().replace(R.id.content_frame , new MainPage()).commit();
        } else if (id == R.id.nav_second_layout) {
            manager.beginTransaction().replace(R.id.content_frame , new Sigs()).commit();
        } else if (id == R.id.nav_third_layout) {
            manager.beginTransaction().replace(R.id.content_frame, new Tutoring()).commit();
        } else if (id == R.id.nav_fourth_layout) {
            manager.beginTransaction().replace(R.id.content_frame, new SocialMedia()).commit();

        } else if (id == R.id.nav_send) {
            String[] email = new String[1];
            email[0]= "njitacm@gmail.com";
            composeEmail(email);
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void composeEmail(String[] addresses) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
