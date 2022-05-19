package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void kategori(View view) {
        Intent ıntent=new Intent(getApplicationContext(),KategoriActivity.class);
        startActivity(ıntent);
    }

    public void sat(View view) {
        Intent ıntent=new Intent(getApplicationContext(),ArabaSatActivity.class);
        startActivity(ıntent);
    }

    public void iletisim(View view) {
        Intent ıntent=new Intent(getApplicationContext(),IletisimActivity.class);
        startActivity(ıntent);
    }
}