package com.tm.medismap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by r on 7/24/2017.
 */

class RecyclerAdapterDokter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    //deklarasi variable context

    private final Context context;

    String [] name={"Drg. Meralda Rossy Syahdinda","drg. Ibnu Sina, Sp.Prost","drg. Laurensia Ratih Prahardhyni","drg. Ibnu Sina, Sp.Prost",
            "Drg. Meralda Rossy Syahdinda","drg. Ibnu Sina, Sp.Prost","drg. Laurensia Ratih Prahardhyni","drg. Ibnu Sina, Sp.Prost"};
    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    public RecyclerAdapterDokter(Context context) {
        this.context=context;
        inflater= LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_listdokter, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.imageView.setTag(holder);

    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();


            //Toast.makeText(context, "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();
            if (position == 0 && position < getItemCount()){
                Intent intent = new Intent(context , DetailDokter.class);
                context.startActivity(intent);
            }


        }
    };



    @Override
    public int getItemCount() {
        return name.length;
    }
}