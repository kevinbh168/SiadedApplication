package com.brena.siadedapplication.Fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.brena.siadedapplication.Adapters.NotasAdapter;
import com.brena.siadedapplication.R;
import com.brena.siadedapplication.data.DataGenerator;
import com.brena.siadedapplication.model.Social;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotasFragment extends Fragment {

    private RecyclerView notasRecyclerView;


    public NotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notas, container, false);
        notasRecyclerView=view.findViewById(R.id.notasRecyclerView);
        notasRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        List<Social> items = DataGenerator.getSocialData(view.getContext());

        NotasAdapter notasAdapter=new NotasAdapter(view.getContext(),items);
        notasRecyclerView.setAdapter(notasAdapter);

        notasAdapter.setOnItemClickListener(new NotasAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Social obj, int position) {
                Toast.makeText(view.getContext(), "Item " + obj.name + " clicked", Toast.LENGTH_SHORT).show();
            }
        });


      /*  cursosListView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"Este curso es "+cursosListView.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }
        });*/
        return view;
    }

}
