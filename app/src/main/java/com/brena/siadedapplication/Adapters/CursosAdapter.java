package com.brena.siadedapplication.Adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.brena.siadedapplication.R;
import com.brena.siadedapplication.model.Bimestre;
import com.brena.siadedapplication.model.Cursos;
import com.brena.siadedapplication.utils.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/3/16.
 */
public class CursosAdapter implements ExpandableListAdapter {

    private Context context;
    private List<Cursos> cursos = new ArrayList<Cursos>();

    public CursosAdapter(Context context, List<Cursos> brands) {
        this.context = context;
        this.cursos = brands;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return cursos.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return cursos.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return cursos.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ParentHolder parentHolder = null;

        Cursos brand = (Cursos) getGroup(groupPosition);

        if(convertView == null) {
            LayoutInflater userInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = userInflater.inflate(R.layout.item_parent_curso, null);
            convertView.setVerticalScrollBarEnabled(true);

            parentHolder = new ParentHolder();
            convertView.setTag(parentHolder);

        } else {
            parentHolder = (ParentHolder) convertView.getTag();
        }

        parentHolder.brandName = (TextView) convertView.findViewById(R.id.curso_name);
        parentHolder.brandName.setText(brand.Nombre);

        parentHolder.indicator = (ImageView) convertView.findViewById(R.id.curso_expand);

        if(isExpanded) {
            Tools.toggleArrow(isExpanded,parentHolder.indicator, false);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildHolder childHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_group_child, parent, false);
            childHolder = new ChildHolder();
            convertView.setTag(childHolder);
        }
        else {
            childHolder = (ChildHolder) convertView.getTag();
        }

        childHolder.BimestresListView = (RecyclerView) convertView.findViewById(R.id.mobiles);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        childHolder.BimestresListView.setLayoutManager(layoutManager);

        BimestreAdapter horizontalListAdapter = new BimestreAdapter(context, cursos.get(groupPosition).bimestres);
        childHolder.BimestresListView.setAdapter(horizontalListAdapter);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    private static class ChildHolder {
        static RecyclerView BimestresListView;
    }

    private static class ParentHolder {
        TextView brandName;
        ImageView indicator;
    }
}
