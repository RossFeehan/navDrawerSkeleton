package com.ross.feehan.navdrawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Context ctx;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.navDrawerRV) RecyclerView navDrawerRV;
    @Bind(R.id.navDrawerLayout) DrawerLayout navDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.ctx = this;

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.toolbarName));

        //set the adapter and layout manager of the recycler view
        navDrawerRV.setLayoutManager(new LinearLayoutManager(ctx));
        navDrawerRV.setAdapter(new NavDrawRecyclerAdapter(ctx));

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, navDrawer,R.string.openDrawer, R.string.closeDrawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // Code here will execute once drawer is opened
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
        };
        navDrawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}