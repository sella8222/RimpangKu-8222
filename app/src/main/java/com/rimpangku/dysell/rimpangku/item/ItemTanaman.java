package com.rimpangku.dysell.rimpangku.item;

import java.util.ArrayList;
import java.util.List;


public class ItemTanaman
{
    private String idTanaman;
    private String nama;
    private String gambar;
    private String manfaat;
    
    private int cocok = 0;
    
    private List<ItemCiri> idCiris;
    
    public ItemTanaman(String idTanaman, String nama, String gambar, String manfaat)
    {
        this.idTanaman = idTanaman;
        this.nama = nama;
        this.gambar = gambar;
        this.manfaat = manfaat;
        
        idCiris = new ArrayList<>();
    }
    
    public String getIdTanaman()
    {
        return idTanaman;
    }
    
    public void setIdTanaman(String idTanaman)
    {
        this.idTanaman = idTanaman;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    
    public String getGambar()
    {
        return gambar;
    }
    
    public void setGambar(String gambar)
    {
        this.gambar = gambar;
    }
    
    public List<ItemCiri> getIdCiris()
    {
        return idCiris;
    }
    
    public void setIdCiris(List<ItemCiri> idCiris)
    {
        this.idCiris = idCiris;
    }
    
    public void addCocok()
    {
        cocok++;
    }
    
    public int getCocok()
    {
        return cocok;
    }
    
    public void setCocok(int cocok)
    {
        this.cocok = cocok;
    }
    
    public String getManfaat()
    {
        return manfaat;
    }
    
    public void setManfaat(String manfaat)
    {
        this.manfaat = manfaat;
    }
}
