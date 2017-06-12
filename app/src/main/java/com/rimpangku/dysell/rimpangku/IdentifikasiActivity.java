package com.rimpangku.dysell.rimpangku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.rimpangku.dysell.rimpangku.db.DataHelper;
import com.rimpangku.dysell.rimpangku.item.ItemCiri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IdentifikasiActivity extends AppCompatActivity implements View.OnClickListener
{

    LinearLayout lytContainer;
    
    Button btnHome;
    Button btnNext;
    
    List<CheckBox> checkBoxes;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identifikasi);
        
        lytContainer = (LinearLayout)findViewById(R.id.vContainer);
        
        btnHome = (Button)findViewById(R.id.btnHome);
        btnNext = (Button)findViewById(R.id.btnNext);
        
        btnHome.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        
        checkBoxes = new ArrayList<>();
        
        isiCek();
    }
    
    private void isiCek()
    {
        List<ItemCiri> l = DataHelper.getAllCiri(this);
        
        for (ItemCiri it : l)
        {
            View v = getLayoutInflater().inflate(R.layout.item_check, null);
            CheckBox ckbCek = (CheckBox)v.findViewById(R.id.ckb);
            ckbCek.setTag(it);
            ckbCek.setText(it.getNamaCiri());
            
            checkBoxes.add(ckbCek);
            lytContainer.addView(v);
        }
    }
    
    @Override
    public void onClick(View v)
    {
        if (v == btnHome)
        {
            finish();
        }
        else if (v == btnNext)
        {
            List<ItemCiri> list = new ArrayList<>();
            
            for (CheckBox c : checkBoxes)
            {
                if (c.isChecked())
                {
                    list.add((ItemCiri)c.getTag());
                }
            }
    
            Intent i = new Intent(this, HasilActivity.class);
            i.putExtra("ciris", (Serializable)list);
            startActivity(i);
        }
    }
}
