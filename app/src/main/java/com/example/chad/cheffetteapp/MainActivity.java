package com.example.chad.cheffetteapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog;
    ArrayList<String> list = new ArrayList<String>();
    Boolean bool;
    static SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            db = this.openOrCreateDatabase("food_app_db", MODE_PRIVATE, null);

            //create a tables and columns
            db.execSQL("CREATE TABLE IF NOT EXISTS catagory (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)");

            db.execSQL("CREATE TABLE IF NOT EXISTS fries (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            db.execSQL("CREATE TABLE IF NOT EXISTS snackbox (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            db.execSQL("CREATE TABLE IF NOT EXISTS chickensandwiches (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            db.execSQL("CREATE TABLE IF NOT EXISTS salads (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            db.execSQL("CREATE TABLE IF NOT EXISTS nuggets (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            db.execSQL("CREATE TABLE IF NOT EXISTS pizza (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            db.execSQL("CREATE TABLE IF NOT EXISTS icecream (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            db.execSQL("CREATE TABLE IF NOT EXISTS chicken (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            db.execSQL("CREATE TABLE IF NOT EXISTS drinks (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price REAL)");

            //put data into the SQLite database
            //catagory table
            db.execSQL("INSERT INTO catagory (name) VALUES ('fries')");
            db.execSQL("INSERT INTO catagory (name) VALUES ('snackbox')");
            db.execSQL("INSERT INTO catagory (name) VALUES ('chickensandwiches')");
            db.execSQL("INSERT INTO catagory (name) VALUES ('salads')");
            db.execSQL("INSERT INTO catagory (name) VALUES ('nuggets')");
            db.execSQL("INSERT INTO catagory (name) VALUES ('pizza')");
            db.execSQL("INSERT INTO catagory (name) VALUES ('icecream')");
            db.execSQL("INSERT INTO catagory (name) VALUES ('chicken')");
            db.execSQL("INSERT INTO catagory (name) VALUES ('drinks')");

        }catch (Exception e){
            e.printStackTrace();
        }

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id) {

                if (position == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//insertdatabasecode

                            if (list.isEmpty()) {
                                list.add("Chips");
                            } else {
                                for (int i = 0; i < list.size(); i++) {
                                    String n = list.get(i).toString();
                                    if (n != "Chips") {
                                        bool = false;
                                        //Toast.makeText(getApplicationContext(), "Already Added", Toast.LENGTH_SHORT).show();e;se
                                    } else {
                                        bool = true;
                                    }
                                    //list.add("Chips");
                                }

                                if (bool == true) {
                                    Toast.makeText(getApplicationContext(), "Already Added", Toast.LENGTH_SHORT).show();
                                } else {
                                    list.add("Chips");
                                }
                            }

                         /*  if(position == 1)
                           {
                               if(list.isEmpty())
                               {
                                   list.add("Roti");
                               }
                               else {
                                   for (int i = 0; i< list.size(); i++) {
                                       String n = list.get(i).toString();
                                       if (n != "Roti") {
                                           bool = false;
                                           //Toast.makeText(getApplicationContext(), "Already Added", Toast.LENGTH_SHORT).show();e;se
                                       } else {
                                           bool = true;

                                       }
                                       //list.add("Chips");
                                   }

                                   if (bool == true) {
                                       Toast.makeText(getApplicationContext(), "Already Added", Toast.LENGTH_SHORT).show();
                                   } else {
                                       list.add("Roti");
                                   }
                               }
                           }
                           if(position == 2)
                           {
                               if(list.isEmpty())
                               {
                                   list.add("Chicken");
                               }else {
                                   for (int i = 0; i < list.size(); i++) {
                                       String n = list.get(i).toString();
                                       if (n != "Chicken") {
                                           bool = false;
                                           //Toast.makeText(getApplicationContext(), "Already Added", Toast.LENGTH_SHORT).show();e;se
                                       } else {
                                           bool = true;

                                       }
                                       //list.add("Chips");
                                   }

                                   if (bool == true) {
                                       Toast.makeText(getApplicationContext(), "Already Added", Toast.LENGTH_SHORT).show();
                                   } else {
                                       list.add("Chicken");
                                   }
                               }
                           }*/
                        }

                    });

                    builder.setNegativeButton("Remove", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
//insert database code
                        }
                    });
                    builder.setMessage("some message:");
                    alertDialog = builder.create();
                    alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogSlideAnim;
                    alertDialog.getWindow().setGravity(Gravity.BOTTOM);
                    alertDialog.show();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        if (alertDialog !=null) {
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
        }
        super.onDestroy();
    }

    /*
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Fries.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SnackBox.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ChickenSandwiches.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Salads.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Nuggets.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Pizza.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + IceCream.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Chicken.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Drink.TABLE);

        // Create tables again
        //onCreate(db);

    }*/

}
