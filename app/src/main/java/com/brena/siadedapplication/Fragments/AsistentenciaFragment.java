package com.brena.siadedapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brena.siadedapplication.Adapters.AsistenciaAdapter;
import com.brena.siadedapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsistentenciaFragment extends Fragment {
    private RecyclerView asistenciaRecyclerView;

    public AsistentenciaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_asistentencia, container, false);
        asistenciaRecyclerView=view.findViewById(R.id.asistenciaRecyclerView);
        asistenciaRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        AsistenciaAdapter asistenciaAdapter=new AsistenciaAdapter();
        asistenciaRecyclerView.setAdapter(asistenciaAdapter);
        return view;
    }

}
