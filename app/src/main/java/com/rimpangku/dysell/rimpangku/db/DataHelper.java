package com.rimpangku.dysell.rimpangku.db;

import android.content.Context;

import com.rimpangku.dysell.rimpangku.item.ItemCiri;
import com.rimpangku.dysell.rimpangku.item.ItemTanaman;

import java.util.ArrayList;
import java.util.List;


public class  DataHelper
{
    public static List<ItemCiri> getAllCiri(Context c)
    {
        List<ItemCiri> l = new ArrayList<>();
        
        String[][] res = SQLiteDataManager.read(c, "SELECT * FROM ciri");
        
        for (String[] s : res)
        {
            l.add(new ItemCiri(s[0], s[1]));
        }
        
        return l;
    }
    
    public static List<ItemTanaman> getAllTanaman(Context c)
    {
        List<ItemTanaman> l = new ArrayList<>();
    
        String[][] res = SQLiteDataManager.read(c, "SELECT * FROM tanaman");
    
        for (String[] s : res)
        {
            ItemTanaman it = new ItemTanaman(s[0], s[1], s[2], s[3]);
            
            String[][] res2 = SQLiteDataManager.read
                    (c, "SELECT ciri.* FROM ciri_tanaman JOIN ciri ON ciri.id_ciri = ciri_tanaman.id_ciri WHERE id_tanaman = " + s[0]);
            
            List<ItemCiri> ciris = new ArrayList<>();
            
            for (String[] ss : res2)
            {
                ciris.add(new ItemCiri(ss[0], ss[1]));
            }
            
            it.setIdCiris(ciris);
            
            l.add(it);
        }
    
        return l;
    }
} 
