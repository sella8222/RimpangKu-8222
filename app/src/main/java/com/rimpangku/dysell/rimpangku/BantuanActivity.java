package com.rimpangku.dysell.rimpangku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class BantuanActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);

        btnHome = (Button)findViewById(R.id.btnHome);

        btnHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if (v == btnHome)
        {
            finish();
        }

    }
}
