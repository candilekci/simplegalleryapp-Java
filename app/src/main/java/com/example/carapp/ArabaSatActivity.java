package com.example.carapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ArabaSatActivity extends AppCompatActivity {

    Button btnGoster;
    final Context context = this;
    ImageView photo;
    static int PReqCode=1;
    static int REQUESCODE=1;
    Uri imageUri;
    SQLite db = new SQLite(context);


    public EditText textMarka;
    public EditText textKM;
    public EditText textFiyat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_araba_sat);

        textMarka = (EditText)findViewById(R.id.editTextTextPersonName);
        textKM = (EditText)findViewById(R.id.editTextNumber2);
        textFiyat = (EditText)findViewById(R.id.editTextNumber3);

        photo=findViewById(R.id.imageView);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=22){
                    checkAndREquestForPermission();
                }
                else{
                    openGalery();
                }
            }
        });



        btnGoster = (Button) findViewById(R.id.button);
            btnGoster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.onUpgrade(db.getWritableDatabase(),1,2);
                   // db.AracEkle(new Arabalar(textMarka.toString(),2015,Integer.parseInt(String.valueOf(textKM)),Integer.parseInt(String.valueOf(textFiyat))));

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    // alert dialog başlığını tanımlıyoruz.
                    alertDialogBuilder.setTitle("BAŞARILI");
                    // alert dialog özelliklerini oluşturuyoruz.
                    alertDialogBuilder
                            .setMessage("SATIŞ BİLGİLERİNİZ BAŞARILI BİR ŞEKİLDE ATINMIŞTIR.")
                            .setCancelable(false)
                            .setIcon(R.mipmap.ic_launcher_round)
                            // Evet butonuna tıklanınca yapılacak işlemleri buraya yazıyoruz.
                            .setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                    // alert dialog nesnesini oluşturuyoruz
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // alerti gösteriyoruz
                    alertDialog.show();
                }
            });
        }

    private void openGalery() {
        Intent intent =new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,REQUESCODE);

    }

    private void checkAndREquestForPermission() {
        if(ContextCompat.checkSelfPermission(ArabaSatActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(ArabaSatActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(ArabaSatActivity.this,"izin kabul",Toast.LENGTH_SHORT).show();;
            }
            else{
                ActivityCompat.requestPermissions(ArabaSatActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PReqCode);
            }
        }
        else
            openGalery();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode== REQUESCODE && data != null){
            imageUri=data.getData();
            photo.setImageURI(imageUri);

        }

    }
}


