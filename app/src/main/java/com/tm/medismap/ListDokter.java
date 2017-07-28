package com.tm.medismap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

/**
 * Created by r on 7/24/2017.
 */

public class ListDokter extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_dokter);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        //menampilkan reyclerview yang ada pada file layout dengan id reycler view

        RecyclerAdapterDokter adapter=new RecyclerAdapterDokter(this);
        //membuat adapter baru untuk reyclerview
        recyclerView.setAdapter(adapter);
        //menset nilai dari adapter
        recyclerView.setHasFixedSize(true);
        //menset setukuran
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //menset layoutmanager dan menampilkan daftar/list
        //dalam bentuk linearlayoutmanager pada class saat ini
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Title");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
