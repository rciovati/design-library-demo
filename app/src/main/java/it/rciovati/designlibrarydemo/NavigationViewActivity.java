package it.rciovati.designlibrarydemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationViewActivity extends AppCompatActivity implements
    NavigationView.OnNavigationItemSelectedListener {

  private ActionBarDrawerToggle mDrawerToggle;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_navigation_view);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

    mDrawerToggle =
        new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,
            R.string.app_name);

    drawerLayout.setDrawerListener(mDrawerToggle);

    final NavigationView nv = (NavigationView) findViewById(R.id.navigation_view);
    nv.setNavigationItemSelectedListener(this);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    // Sync the toggle state after onRestoreInstanceState has occurred.
    mDrawerToggle.syncState();
  }

  @Override public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Pass the event to ActionBarDrawerToggle, if it returns
    // true, then it has handled the app icon touch event
    if (mDrawerToggle.onOptionsItemSelected(item)) {
      return true;
    }
    // Handle your other action bar items...

    return super.onOptionsItemSelected(item);
  }

  @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
    menuItem.setChecked(true);
    Toast.makeText(this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
    return true;
  }
}
