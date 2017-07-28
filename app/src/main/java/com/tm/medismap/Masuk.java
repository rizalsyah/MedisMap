package com.tm.medismap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by r on 7/24/2017.
 */

public class Masuk extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masuk);
        Button daftar = (Button) findViewById(R.id.daftar);
        Button btnmasuk = (Button) findViewById(R.id.btn_masuk);
        btnmasuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextScreen = new Intent(getApplicationContext(), Menu.class);
                startActivity(nextScreen);

            }
        });

        daftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextScreen = new Intent(getApplicationContext(), Daftar.class);
                startActivity(nextScreen);

            }
        });


    }
}
