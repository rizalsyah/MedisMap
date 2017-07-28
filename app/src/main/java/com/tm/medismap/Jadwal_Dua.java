package com.tm.medismap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by r on 7/26/2017.
 */

class Jadwal_Dua extends android.support.v4.app.Fragment {

    TextView textView;

    public Jadwal_Dua() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.jadwal_dua, container, false);
        Button booking =(Button) view.findViewById(R.id.booking);
        booking.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextScreen = new Intent(getActivity(), Booking.class);
                startActivity(nextScreen);
            }
        });
        return view;
    }
}