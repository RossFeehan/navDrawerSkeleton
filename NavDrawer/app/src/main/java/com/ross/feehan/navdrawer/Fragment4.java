package com.ross.feehan.navdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ross Feehan on 18/12/2015.
 * Copyright Ross Feehan
 */
public class Fragment4 extends Fragment {

    @Bind(R.id.fragmentTV)
    TextView fragTV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_layouts, container, false);
        ButterKnife.bind(this, view);

        fragTV.setText("Menu Item 4");

        return view;
    }
}
