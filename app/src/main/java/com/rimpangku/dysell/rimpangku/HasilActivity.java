package com.rimpangku.dysell.rimpangku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.rimpangku.dysell.rimpangku.adapter.AdpTanaman;
import com.rimpangku.dysell.rimpangku.classes.ClassUtil;
import com.rimpangku.dysell.rimpangku.db.DataHelper;
import com.rimpangku.dysell.rimpangku.item.ItemCiri;
import com.rimpangku.dysell.rimpangku.item.ItemTanaman;

import java.util.ArrayList;
import java.util.List;

public class HasilActivity extends AppCompatActivity {

    TextView txtNama, txtCiri, txtManfaat;
    ImageView imgGambar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        
        txtNama = (TextView)findViewById(R.id.txtNama);
        txtCiri = (TextView)findViewById(R.id.txtCiri);
        txtManfaat = (TextView)findViewById(R.id.txtManfaat);
        
        imgGambar = (ImageView)findViewById(R.id.imgGambar); 
        
        refreshList();
    }
    
    private void refreshList()
    {
        List<ItemCiri> ciris = (List<ItemCiri>)getIntent().getSerializableExtra("ciris");
        
        List<ItemTanaman> lIt = DataHelper.getAllTanaman(this);
        
        for (ItemTanaman it : lIt)
        {
            for (ItemCiri itc1 : it.getIdCiris())
            {
                for (ItemCiri itc : ciris)
                {
                    if (itc1.getIdCiri().equals(itc.getIdCiri()))
                    {
                        it.addCocok();
                    }
                }
            }
        }
        
        ItemTanaman res = null;
        int max = 0;
        
        for (ItemTanaman it : lIt)
        {
            if (it.getCocok() > max)
            {
                res = it;
                max = it.getCocok();
            }
        }        
        
        if (res == null && lIt.size() > 0)
            res = lIt.get(0);
        
        if (res != null)
            isi(res);
    }
    
    private void isi(ItemTanaman it)
    {
        imgGambar.setImageBitmap(ClassUtil.getBitmapFromAsset(this, "images/" + it.getGambar()));
        
        txtNama.setText(it.getNama());
        txtManfaat.setText("MANFAAT : \n" + it.getManfaat());
        
        String ciri = "";
        
        for (int a = 0; a < it.getIdCiris().size(); a++)
        {
            ciri += " - " + it.getIdCiris().get(a).getNamaCiri();
            
            if (a < it.getIdCiris().size() - 1)
                ciri += "\n";
        }
        
        txtCiri.setText("CIRI-CIRI : \n" + ciri);
    }
}
