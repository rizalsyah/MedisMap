package com.tm.medismap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by r on 7/24/2017.
 */

public class GridAdapterMenu extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<ItemObject> listStorage;
    private Context context;

    public GridAdapterMenu(Context context, List<ItemObject> customizedListView) {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.item_menu, parent, false);
            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.textView);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.imageView);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }

        listViewHolder.textInListView.setText(listStorage.get(position).getContent());
        int imageResourceId = this.context.getResources().getIdentifier(listStorage.get(position).getImageResource(), "mipmap", this.context.getPackageName());
        listViewHolder.imageInListView.setImageResource(imageResourceId);

        return convertView;
    }

    static class ViewHolder{
        TextView textInListView;
        ImageView imageInListView;
    }



}