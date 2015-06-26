package com.dh.congcusonet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;


public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener, View.OnClickListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private LinearLayout btn_nav_mb;
    private LinearLayout btn_nav_mt;
    private LinearLayout btn_nav_mn;
    private LinearLayout btn_nav_sl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);


    }

    private void init() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        btn_nav_mb = (LinearLayout) findViewById(R.id.btn_nav_mb);
        btn_nav_mt = (LinearLayout) findViewById(R.id.btn_nav_mt);
        btn_nav_mn = (LinearLayout) findViewById(R.id.btn_nav_mn);
        btn_nav_sl = (LinearLayout) findViewById(R.id.btn_nav_sl);

        btn_nav_mb.setOnClickListener(this);
        btn_nav_mt.setOnClickListener(this);
        btn_nav_mn.setOnClickListener(this);
        btn_nav_sl.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_calendar) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new XSMBFragment();
                title = getString(R.string.nav_item_xsmb);
                break;
            case 1:
                fragment = new XSMTFragment();
                title = getString(R.string.nav_item_xsmt);
                break;
            case 2:
                fragment = new XSMNFragment();
                title = getString(R.string.nav_item_xsmn);
                break;
            case 3:
                fragment = new SoLocFragment();
                title = getString(R.string.nav_item_so_loc);
                break;
            case 4:
                fragment = new CalendarFragment();
                title = getString(R.string.nav_item_calendar);
                break;
            case 5:
                fragment = new TienIchFragment();
                title = getString(R.string.nav_item_tien_ich);
                break;
            case 6:
                fragment = new SetUpFragment();
                title = getString(R.string.nav_item_setup);
                break;
            case 7:
                fragment = new RateFragment();
                title = getString(R.string.nav_item_rate);
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_nav_mb:
                displayView(0);
                break;
            case R.id.btn_nav_mt:
                displayView(1);
                break;
            case R.id.btn_nav_mn:
                displayView(2);
                break;
            case R.id.btn_nav_sl:
                displayView(3);
                break;
            default:
                break;
        }
    }
}
