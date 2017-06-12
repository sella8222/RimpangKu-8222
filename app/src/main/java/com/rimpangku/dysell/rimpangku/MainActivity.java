package com.rimpangku.dysell.rimpangku;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.constraint.ConstraintLayout;
import android.widget.Button;

import static com.rimpangku.dysell.rimpangku.R.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    View vIdentifikasi;
    View vBantuan;
    View vKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vIdentifikasi = findViewById(R.id.vIdentifikasi);
        vBantuan = findViewById(id.vBantuan);
        vKeluar = findViewById(R.id.vKeluar);

        vIdentifikasi.setOnClickListener(this);
        vBantuan.setOnClickListener(this);
        vKeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == vIdentifikasi)
        {
            Intent i = new Intent(this, IdentifikasiActivity.class);
            startActivity(i);
        }
        else if (v == vBantuan)
        {
            Intent i = new Intent(this, BantuanActivity.class);
            startActivity(i);
        }
        else if (v == vKeluar)
        {
            finish();
        }
    }

    @Override
    public void onBackPressed(){
       //exit dari app  dengan konfirmasi AlerDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Anda yakin ingin keluar?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
