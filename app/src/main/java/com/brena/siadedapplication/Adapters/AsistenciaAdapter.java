package com.brena.siadedapplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brena.siadedapplication.R;

public class AsistenciaAdapter extends RecyclerView.Adapter<AsistenciaAdapter.ViewHolder> {
    @NonNull
    @Override
    public AsistenciaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_asistencia,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsistenciaAdapter.ViewHolder viewHolder, int i) {
        final Context context=viewHolder.circleEstadoImageView.getContext();
        if(i == 25 || i == 2 || i == 10 ){
            viewHolder.circleEstadoImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.shadow_circle_feriado));
            viewHolder.horaTextView.setText("SIN HORA");
            viewHolder.estadoTextView.setText("FERIADO");
        }
        if(i == 3 || i == 9 || i == 15 ){
            viewHolder.circleEstadoImageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.shadow_circle_tardanza));
            viewHolder.horaTextView.setText("Hora: 07:15");
            viewHolder.estadoTextView.setText("TARDANZA");
        }

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView circleEstadoImageView;
        private TextView estadoTextView;
        private TextView horaTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleEstadoImageView=itemView.findViewById(R.id.circle_estado);
            estadoTextView=itemView.findViewById(R.id.estadoAsisText);
            horaTextView=itemView.findViewById(R.id.horaAsisText);
        }
    }
}
