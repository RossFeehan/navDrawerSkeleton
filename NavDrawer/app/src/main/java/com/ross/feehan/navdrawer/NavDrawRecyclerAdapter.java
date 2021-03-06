package com.ross.feehan.navdrawer;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ross Feehan on 17/12/2015.
 * Copyright Ross Feehan
 */
public class NavDrawRecyclerAdapter extends RecyclerView.Adapter<NavDrawRecyclerAdapter.NavDrawerHolder>{

    private Context ctx;
    private List<String> menuItems;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static DrawerLayout navDrawer;

    public NavDrawRecyclerAdapter(Context ctx, DrawerLayout navDrawer){
        this.ctx = ctx;
        this.navDrawer = navDrawer;
        this.menuItems = Arrays.asList(ctx.getResources().getStringArray(R.array.menuItems));
    }

    /*Method that creates and returns an instance of NavDrawerHolder and inflates the correct layout
     */
    @Override
    public NavDrawerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NavDrawerHolder navDrawerHolder;
        View view;

        if(viewType == TYPE_HEADER){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_drawer_header, parent, false);

        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_draw_item_row, parent, false);
        }
        navDrawerHolder = new NavDrawerHolder(view, viewType, ctx);
        return navDrawerHolder;
    }

    /*Method that populates the views with the correct information
     */
    @Override
    public void onBindViewHolder(NavDrawerHolder holder, int position) {
        if(holder.holderID == 1){
            holder.navDrawerItemTV.setText(menuItems.get(position-1));
        }
        else{
            holder.navDrawerHeaderNameTV.setText(R.string.naveDrawName);
        }
    }

    @Override
    public int getItemCount() {
        //plus one for the nav drawer header
        return menuItems.size()+1;
    }

    // With the following method we check what type of view is being passed
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)){
            return TYPE_HEADER;
        }
        else{
            return TYPE_ITEM;
        }
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    /*public class that holds the layout for the Nav Drawer
         *Uses the view holder pattern
         */
    public static class NavDrawerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context ctx;
        @Nullable @Bind(R.id.navDrawMenuRowText) protected TextView navDrawerItemTV;
        @Nullable @Bind(R.id.navDrawerHeaderNameTV) protected TextView navDrawerHeaderNameTV;
        int holderID;

        public NavDrawerHolder(View itemView, int viewType, Context ctx) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.ctx = ctx;

            if(viewType == TYPE_ITEM){
                holderID = 1;
            }

            itemView.setOnClickListener(this);
        }

        //handle the clicks on the menu items
        @Override
        public void onClick(View v) {
            Fragment frag = null;
            switch(getAdapterPosition()){
                case 0:
                    frag = new ProfileFragment();
                    break;
                case 1:
                    frag = new Fragment1();
                    break;
                case 2:
                    frag = new Fragment2();
                    break;
                case 3:
                    frag = new Fragment3();
                    break;
                case 4:
                    frag = new Fragment4();
                    break;
                case 5:
                    frag = new Fragment5();
                    break;
                case 6:
                    frag = new Fragment6();
                    break;
            }

            FragmentTransaction fragTransact = ((AppCompatActivity)ctx).getSupportFragmentManager().beginTransaction();
            fragTransact.replace(R.id.fragmentArea, frag);
            fragTransact.commit();
            navDrawer.closeDrawers();
        }
    }
}
