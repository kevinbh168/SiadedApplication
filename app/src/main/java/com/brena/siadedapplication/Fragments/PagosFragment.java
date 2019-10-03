package com.brena.siadedapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brena.siadedapplication.Adapters.PagosAdapter;
import com.brena.siadedapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PagosFragment extends Fragment {

    private RecyclerView recyclerView;

    public PagosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_pagos, container, false);
        recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        PagosAdapter pagosAdapter =new PagosAdapter();
        recyclerView.setAdapter(pagosAdapter);
        return view;
    }

}
