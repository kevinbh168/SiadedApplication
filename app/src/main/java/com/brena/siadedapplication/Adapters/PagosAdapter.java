package com.brena.siadedapplication.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.brena.siadedapplication.R;

public class PagosAdapter extends RecyclerView.Adapter<PagosAdapter.ViewHolder> {
    @NonNull
    @Override
    public PagosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_pagos,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagosAdapter.ViewHolder viewHolder, int i) {
        final Context context=viewHolder.tituloTextView.getContext();

        if(i>5) {
            viewHolder.tituloTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.danger));
            viewHolder.estadoteTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_icon_danger,0,0,0);
            viewHolder.estadoteTextView.setText(" DEUDA");
        }
        if(i>6){
            viewHolder.tituloTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.warning));
            viewHolder.estadoteTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_icon_error,0,0,0);
            viewHolder.estadoteTextView.setText(" PENDIENTE");
        }

        viewHolder.menuImageButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, viewHolder.menuImageButton);
                popupMenu.inflate(R.menu.menu_pagos_opciones);
                popupMenu.setGravity(Gravity.RIGHT);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.card_pagos_detalles:
                                Toast.makeText(context, "DETALLES", Toast.LENGTH_LONG).show();
                                break;
                            case R.id.card_pagos_descargar:
                                Toast.makeText(context,  "DESCARGAR", Toast.LENGTH_LONG).show();
                                break;

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tituloTextView;
        private TextView estadoteTextView;
        private ImageButton menuImageButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        tituloTextView=itemView.findViewById(R.id.titulo);
        estadoteTextView=itemView.findViewById(R.id.estadoText);
        menuImageButton=itemView.findViewById(R.id.pago_menu);

        }
    }
}
