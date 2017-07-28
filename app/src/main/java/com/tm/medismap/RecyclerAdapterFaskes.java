package com.tm.medismap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by r on 7/26/2017.
 */

class RecyclerAdapterFaskes extends  RecyclerView.Adapter<RecyclerViewHolder> {

    //deklarasi variable context

    private final Context context;

    String[] name = {"Klinik Utama Sahabat Medika", "Klinik El Shafi", "Klinik Telkomedika Makassar",
            "Klinik Fertilitas dan Bayi Tabung Tiara Cita",
            "Klinik Utama Sahabat Medika", "Klinik El Shafi", "Klinik Telkomedika Makassar",
            "Klinik Fertilitas dan Bayi Tabung Tiara Cita"};
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;

    public RecyclerAdapterFaskes(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_listfaskes, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv3.setText(name[position]);
        holder.tv3.setOnClickListener(clickListener);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv3.setTag(holder);
        holder.imageView.setTag(holder);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();


            //Toast.makeText(context, "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();
            if (position == 0 && position < getItemCount()) {
                Intent intent = new Intent(context, DetailDokter.class);
                context.startActivity(intent);
            }


        }
    };


    @Override
    public int getItemCount() {
        return name.length;
    }
}