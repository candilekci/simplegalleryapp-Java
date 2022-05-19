package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class KategoriActivity extends AppCompatActivity {
    Context context = this;
    ListView listemiz;
    List<Arabalar> list;
    SQLite db = new SQLite(context);
    ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);


        listemiz = (ListView) findViewById(R.id.listemiz);
        db.onUpgrade(db.getWritableDatabase(),1,2);
        db.AracEkle(new Arabalar("BMW X5",2016,50000,600000));
        db.AracEkle(new Arabalar("AUDI A3",2015,30000,300000));
        db.AracEkle(new Arabalar("HYUNDAI ACCENT",2018,20000,350000));
        db.AracEkle(new Arabalar("VOLVO S60",2014,214000,398000));
        db.AracEkle(new Arabalar("VOLVO CX90",2019,15400,650000));
        db.AracEkle(new Arabalar("HONDA CIVIC",2018,54100,195000));
        db.AracEkle(new Arabalar("FORD FOCUS",2012,155000,125000));
        db.AracEkle(new Arabalar("FIAT EGEA",2019,15000,218500));
        db.AracEkle(new Arabalar("ISUZU D-MAX",2015,245100,321500));
        db.AracEkle(new Arabalar("BMW 520D",2010,218000,405500));
        db.AracEkle(new Arabalar("BMW 320D",2008,425000,329500));
        db.AracEkle(new Arabalar("MERCEDES S400",2017,125320,635000));
        db.AracEkle(new Arabalar("TOYOTA COROLLA",1999,350400,75000));
        list = db.AracListele();
        List<String> listBaslik = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            listBaslik.add(i, " Arac Model : " + list.get(i).getAracModel() + "\n Arac Fiyat:"
                    + String.valueOf(list.get(i).getAracFiyat()) + "\n Arac Yıl :"
                    + String.valueOf(list.get(i).getAracYIL()) + "\n Arac KM:"
                    + String.valueOf(list.get(i).getAracKM()) + "\n"
            );
        }
        mAdapter = new ArrayAdapter<String>(context,R.layout.satir_layout,R.id.list_Metin,listBaslik);
        listemiz.setAdapter(mAdapter);
    }


}