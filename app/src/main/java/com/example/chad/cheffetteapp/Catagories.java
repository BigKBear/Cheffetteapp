package com.example.chad.cheffetteapp;

/**
 * Created by Kyle Temp on 22/05/2016.
 */
public class Catagories {
    // Labels table name
    public static final String TABLE = "Catagories";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";

    // property help us to keep data
    public int catagories_ID;
    public String name;

    // getting ID
    public int getID(){
        return this.catagories_ID;
    }

    // setting id
    public void setID (int id){
        this.catagories_ID = id;
    }

    //getting name
    public String getName(){
        return this.name;
    }

    //setting name
    public void setNAme(String name){
        this.name = name;
    }
}