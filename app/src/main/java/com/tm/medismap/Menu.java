package com.tm.medismap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


/**
 * Created by r on 7/24/2017.
 */

public class Menu extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.mipmap.satu,R.mipmap.dua,R.mipmap.satu,R.mipmap.dua};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196f3")));


        /*Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);*/

        GridView gridview = (GridView) findViewById(R.id.gridview);

        List<ItemObject> allItems = getAllItemObject();
        GridAdapterMenu customAdapter = new GridAdapterMenu(Menu.this, allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0 ) {
                    Intent intent = new Intent(Menu.this, ListDokter.class);
                    Menu.this.startActivity(intent);
                }
                else if (position == 1 ) {
                    Intent intent = new Intent(Menu.this, ListFaskes.class);
                    Menu.this.startActivity(intent);
                }

                //Toast.makeText(Menu.this, "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        init();
    }
    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new ImageAdapter(Menu.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }
    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    private List<ItemObject> getAllItemObject(){
        ItemObject itemObject = null;
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("Dokter", "medismap"));
        items.add(new ItemObject("Fasilitas Kesehatan", "medismap"));
        items.add(new ItemObject("Favorit", "medismap"));
        items.add(new ItemObject("Histori", "medismap"));
        items.add(new ItemObject("Profil", "medismap"));
        items.add(new ItemObject("Setting", "medismap"));
        return items;
    }



}
