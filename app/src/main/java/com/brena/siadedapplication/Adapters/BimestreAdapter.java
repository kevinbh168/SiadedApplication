package com.brena.siadedapplication.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brena.siadedapplication.R;
import com.brena.siadedapplication.model.Bimestre;

import java.util.ArrayList;
import java.util.List;

public class BimestreAdapter extends RecyclerView.Adapter<BimestreAdapter.ViewHolder> {

    private Context context;
    private List<Bimestre> mobiles = new ArrayList<Bimestre>();

    public BimestreAdapter(Context context, List<Bimestre> mobiles) {
        this.context = context;
        this.mobiles = mobiles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cardView = inflater.inflate(R.layout.item_child, null, false);
        ViewHolder viewHolder = new ViewHolder(cardView);
        viewHolder.price = (TextView) cardView.findViewById(R.id.bimestre_text);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        TextView priceTextView = (TextView) holder.price;
        priceTextView.setText(mobiles.get(position).bimestre);

    }

    @Override
    public int getItemCount() {
        return mobiles.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mobileImage;
        TextView modelName;
        TextView price;

        public ViewHolder(View itemView) {
            super(itemView);

            price = (TextView) itemView.findViewById(R.id.bimestre_text);
        }
    }

}

