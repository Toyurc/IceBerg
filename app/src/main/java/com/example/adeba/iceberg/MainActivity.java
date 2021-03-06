package com.example.adeba.iceberg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.adeba.iceberg.userInterfaceLayer.adapters.StegFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    StegFragmentAdapter stegFragmentAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        stegFragmentAdapter = new StegFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(stegFragmentAdapter);
    }

   }