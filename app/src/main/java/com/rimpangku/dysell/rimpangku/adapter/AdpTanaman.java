package com.rimpangku.dysell.rimpangku.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rimpangku.dysell.rimpangku.R;
import com.rimpangku.dysell.rimpangku.classes.ClassUtil;
import com.rimpangku.dysell.rimpangku.item.ItemTanaman;

import java.util.List;


public class AdpTanaman extends ArrayAdapter<ItemTanaman>
{
    public AdpTanaman(Context context, int resource, List<ItemTanaman> objects)
    {
        super(context, resource, objects);
    }
    
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        
        if (v == null)
            v = LayoutInflater.from(getContext()).inflate(R.layout.item_tanaman, null);
    
        TextView txtNama = (TextView)v.findViewById(R.id.txtNama);
        ImageView imgGambar = (ImageView)v.findViewById(R.id.imgGambar);
        
        ItemTanaman it = getItem(position);
        
        txtNama.setText(it.getNama());
        imgGambar.setImageBitmap(ClassUtil.getBitmapFromAsset(getContext(), "images/" + it.getGambar()));
                
        return v;
    }
}
