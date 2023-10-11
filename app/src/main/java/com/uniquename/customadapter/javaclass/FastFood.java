package com.uniquename.customadapter.javaclass;

public class FastFood {
    private String title;
    private String description;

    private int photo;

    public FastFood(String title, String description){
        this.title=title;
        this.description=description;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public void  setPhoto(int photo){
        this.photo=photo;
    }

    public int getPhoto(){
        return this.photo;
    }
}
