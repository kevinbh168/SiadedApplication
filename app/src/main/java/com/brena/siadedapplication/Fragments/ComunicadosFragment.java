package com.brena.siadedapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brena.siadedapplication.Adapters.ComunicadosAdapter;
import com.brena.siadedapplication.R;


public class ComunicadosFragment extends Fragment {

    private RecyclerView comunicadosRecyclerView;
    public ComunicadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_comunicados, container, false);
        comunicadosRecyclerView=view.findViewById(R.id.comunicadoRecyclerView);
        comunicadosRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ComunicadosAdapter comunicadosAdapter=new ComunicadosAdapter();

        comunicadosRecyclerView.setAdapter(comunicadosAdapter);
        return view;
    }

}
