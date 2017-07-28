package com.tm.medismap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by r on 7/27/2017.
 */

public class Pasien_Baru extends android.support.v4.app.Fragment {
    public Pasien_Baru() {
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
        View view = inflater.inflate(R.layout.pasien_baru, container, false);
        EditText nomor = (EditText) view.findViewById(R.id.editText);
        return view;
    }

}