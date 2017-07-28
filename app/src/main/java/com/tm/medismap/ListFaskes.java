package com.tm.medismap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

/**
 * Created by r on 7/26/2017.
 */

public class ListFaskes extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_faskes);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        //menampilkan reyclerview yang ada pada file layout dengan id reycler view

        RecyclerAdapterFaskes adapter=new RecyclerAdapterFaskes(this);
        //membuat adapter baru untuk reyclerview
        recyclerView.setAdapter(adapter);
        //menset nilai dari adapter
        recyclerView.setHasFixedSize(true);
        //menset setukuran
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //menset layoutmanager dan menampilkan daftar/list
        //dalam bentuk linearlayoutmanager pada class saat ini

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
