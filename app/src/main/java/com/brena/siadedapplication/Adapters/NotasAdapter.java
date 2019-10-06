package com.brena.siadedapplication.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.brena.siadedapplication.R;
import com.brena.siadedapplication.model.Social;
import com.brena.siadedapplication.utils.Tools;
import com.brena.siadedapplication.utils.ViewAnimation;

import java.util.ArrayList;
import java.util.List;

public class NotasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Social> items = new ArrayList<>();
    private String cursos[]={"Curso 1", "Curso 2","Curso 3"};
    private String bimestres[]={"Bimestre I", "Bimestre II", "Bimestre III","Bimestre IV"};

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Social obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public NotasAdapter(Context context, List<Social> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        private TextView notasArea;
        public ImageButton bt_expand;
        public View lyt_expand;
        public View lyt_parent;
        private ListView cursoListView;
        public OriginalViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            name = (TextView) v.findViewById(R.id.name);
            bt_expand = (ImageButton) v.findViewById(R.id.bt_expand);
            lyt_expand = (View) v.findViewById(R.id.lyt_expand);
            lyt_parent = (View) v.findViewById(R.id.lyt_parent);
            cursoListView=v.findViewById(R.id.cursoListView);
            notasArea=v.findViewById(R.id.areaNotas);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_notas, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            final OriginalViewHolder view = (OriginalViewHolder) holder;
            final Context context=view.cursoListView.getContext();

            ArrayAdapter <String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,bimestres);
            view.cursoListView.setAdapter(adapter);

            final Social p = items.get(position);
            view.notasArea.setText(p.name);
            view.name.setText("curso 1");
            //Tools.displayImageOriginal(ctx, view.image, p.image);
            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });

            view.bt_expand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean show = toggleLayoutExpand(!p.expanded, v, view.lyt_expand);
                    items.get(position).expanded = show;
                }
            });

            // void recycling view
            if(p.expanded){
                view.lyt_expand.setVisibility(View.VISIBLE);
            } else {
                view.lyt_expand.setVisibility(View.GONE);
            }
            Tools.toggleArrow(p.expanded, view.bt_expand, false);

        }
    }

    private boolean toggleLayoutExpand(boolean show, View view, View lyt_expand) {
        Tools.toggleArrow(show, view);
        if (show) {
            ViewAnimation.expand(lyt_expand);
        } else {
            ViewAnimation.collapse(lyt_expand);
        }
        return show;
    }

    @Override
    public int getItemCount() {
        return 4;
    }


}