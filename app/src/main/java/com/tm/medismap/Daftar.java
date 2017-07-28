package com.tm.medismap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r on 7/24/2017.
 */

public class Daftar extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener*/ {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);
        Button btnmasuk = (Button) findViewById(R.id.masuk);
        btnmasuk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextScreen = new Intent(getApplicationContext(), Masuk.class);
                startActivity(nextScreen);

            }
        });
        /*Spinner user_status = (Spinner) findViewById(R.id.user_status);

        // Spinner click listener
        user_status.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Pasien");
        categories.add("Dokter");
        categories.add("Fasilitas Kesehatan");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        user_status.setAdapter(dataAdapter);*/
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DaftarTabAkun(), "Akun");
        adapter.addFragment(new DaftarTabBiodata(), "Biodata");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }

}
