package com.example.isidr.schoolsisidro.Vista;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.isidr.schoolsisidro.Control.MainMenu;
import com.example.isidr.schoolsisidro.R;
import com.example.isidr.schoolsisidro.Control.SQLite_Towns_and_schools;

public class MainActivity extends MainMenu {

    SQLite_Towns_and_schools connexion;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connexion = new SQLite_Towns_and_schools(this);
        db = connexion.getWritableDatabase();

        //Inserir dades en la BD
        /*if(db != null) {
            //Inserting Town
            InsertTowns(1, "Tavernes de la Valldigna", 39.0724867, -0.2694566);
            InsertTowns(2, "Simat de la Valldigna", 39.0436023, -0.3100889);
            InsertTowns(3, "Benifairo de la Valldigna", 39.0540847, -0.3031696);
            //Inserting School
            //Tavernes
            InsertSchools(1, "Sant Miquel", 1, "Public", 39.0694609, -0.2752526);
            InsertSchools(2, "Alfandec", 1, "Public", 39.0698869, -0.2644222);
            InsertSchools(3, "Divina Aurora", 1, "Public", 39.0741875, -0.2690094);
            InsertSchools(4, "Centro de Enseñanza San José", 1, "Private", 39.0713583, -0.2663264);
            //Simat
            InsertSchools(5, "Valldigna", 2, "Public", 39.0449216, -0.3141813);
            //Benifairó
            InsertSchools(6, "Jaume II el Just", 3, "Public", 39.0560931, -0.3038732);
            //Closing the database
            db.close();
        }*/

    }

    public void InsertTowns (int code, String name, double lat, double lon) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("Code", code);
        nuevoRegistro.put("Name", name);
        nuevoRegistro.put("Lat", lat);
        nuevoRegistro.put("Lon", lon);
        db.insert("Towns", null, nuevoRegistro);
    }

    public void InsertSchools (int code, String name, int town, String Kind_of_School, double lat, double lon) {
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("Code", code);
        nuevoRegistro.put("Name", name);
        nuevoRegistro.put("Town", town);
        nuevoRegistro.put("Kind_of_School", Kind_of_School);
        nuevoRegistro.put("Lat", lat);
        nuevoRegistro.put("Lon", lon);
        db.insert("Schools", null, nuevoRegistro);
    }



}
