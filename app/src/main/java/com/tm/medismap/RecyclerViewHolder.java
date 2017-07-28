package com.tm.medismap;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by r on 7/24/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        // ViewHolder akan mendeskripisikan item view yang ditempatkan di dalam RecyclerView.
        TextView tv1,tv2, tv3, tv4,nama_menu, nama_bank; //deklarasi textview
        ImageView imageView;  //deklarasi imageview
        Button button;

public RecyclerViewHolder(View itemView) {
        super(itemView);

        tv1= (TextView) itemView.findViewById(R.id.nama_dokter);
        //menampilkan text dari widget CardView pada id daftar_judul
        tv2= (TextView) itemView.findViewById(R.id.keahlian);
        tv3= (TextView) itemView.findViewById(R.id.nama_faskes);
        //menampilkan text dari widget CardView pada id daftar_judul
        tv4= (TextView) itemView.findViewById(R.id.alamat);
        //menampilkan text deskripsi dari widget CardView pada id daftar_deskripsi
        imageView= (ImageView) itemView.findViewById(R.id.foto_dokter);
        //menampilkan gambar atau icon pada widget Cardview pada id daftar_icon
        /*nama_bank= (TextView) itemView.findViewById(R.id.nama_bank);*/
        }
        }