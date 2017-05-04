package com.example.user.uiassignment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import fragments.MainFragment;

import static android.support.design.widget.TabLayout.OnClickListener;

/**
 * main activity class
 */
public class MainActivity extends AppCompatActivity implements OnClickListener {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ImageButton ibtnDrawer;
    private ImageButton ibtnListView;
    private ImageButton ibtnGridView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        ibtnDrawer = (ImageButton) toolbar.findViewById(R.id.button_first);
        ibtnListView = (ImageButton) toolbar.findViewById(R.id.button_second);
        ibtnGridView = (ImageButton) toolbar.findViewById(R.id.button_third);
        ibtnDrawer.setImageResource(R.drawable.burger);
        ibtnListView.setImageResource(R.drawable.sorti);
        ibtnGridView.setImageResource(R.drawable.grid_view);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ibtnDrawer.setOnClickListener(this);
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.viewpager_fragment_container, new MainFragment());
        fragmentTransaction.commit();


    }

    /**
     * method to open drwaer
     */
    public void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    /**
     * methhod to close  drawer
     */
    public void closeDrawer() {
        drawerLayout.closeDrawers();
    }

    @Override
    public void onClick(final View v) {
        openDrawer();
    }

    /**
     * method to get toolbar object
     *
     * @return toolbar object
     */
    public Toolbar getToolbar() {
        return toolbar;
    }


}
