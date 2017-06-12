package com.rimpangku.dysell.rimpangku.item;

import java.io.Serializable;

public class ItemCiri implements Serializable
{
    private String idCiri;
    private String namaCiri;
    
    public ItemCiri(String idCiri, String namaCiri)
    {
        this.idCiri = idCiri;
        this.namaCiri = namaCiri;
    }
    
    public String getIdCiri()
    {
        return idCiri;
    }
    
    public void setIdCiri(String idCiri)
    {
        this.idCiri = idCiri;
    }
    
    public String getNamaCiri()
    {
        return namaCiri;
    }
    
    public void setNamaCiri(String namaCiri)
    {
        this.namaCiri = namaCiri;
    }
}
