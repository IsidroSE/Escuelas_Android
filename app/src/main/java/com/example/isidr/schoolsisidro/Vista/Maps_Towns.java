package com.example.isidr.schoolsisidro.Vista;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.isidr.schoolsisidro.Control.MainMenu;
import com.example.isidr.schoolsisidro.R;
import com.example.isidr.schoolsisidro.Control.SQLite_Towns_and_schools;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps_Towns extends MainMenu implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    SQLite_Towns_and_schools connexion;
    SQLiteDatabase db;
    Intent intent;
    Bundle b;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_poblacions);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Declarar el listener dels marcadors
        mMap.setOnMarkerClickListener(this);
        //Declarar la conexió de la base de dades
        connexion = new SQLite_Towns_and_schools(this);
        db = connexion.getWritableDatabase();
        //Declarar el marcador i la posicio de este
        Marker marker;
        LatLng posicio;
        //Recollint dades de la base de dades
        Cursor c = db.rawQuery("SELECT Name, Lat, Lon FROM Towns", null);
        if (c.moveToFirst()) {
            do {
                String name = c.getString(0);
                double lat = c.getDouble(1);
                double lon = c.getDouble(2);
                posicio = new LatLng(lat, lon);
                marker = mMap.addMarker(new MarkerOptions()
                        .position(posicio).title(name).snippet("Valencia"));

            } while (c.moveToNext());
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.0727884, -0.274921), 12));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        String id = marker.getId();
        Context context;
        CharSequence text;
        int duration;
        Toast toast;
        switch (id) {
            case "m0":
                //Tavernes
                /*Si apretem en el marcador de Tavernes, eixirá un AlertDialog que mos donará a triar 2 opcions: mostrar només les escoles privades, o bé les públiques*/
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Type:");
                builder.setMessage("Select the kind of school that you want to show.");

                builder.setPositiveButton("State Schools", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(Maps_Towns.this, Maps_Schools.class);
                        b = new Bundle();
                        b.putInt("town", 1);
                        b.putString("type", "Public");
                        intent.putExtras(b);
                        startActivityForResult(intent, 5);
                    }
                });

                builder.setNegativeButton("Private Schools", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        intent = new Intent(Maps_Towns.this, Maps_Schools.class);
                        b = new Bundle();
                        b.putInt("town", 1);
                        b.putString("type", "Private");
                        intent.putExtras(b);
                        startActivityForResult(intent, 5);
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

                break;
            case "m1":
                //Simat
                intent = new Intent(Maps_Towns.this, Maps_Schools.class);
                b = new Bundle();
                b.putInt("town", 2);
                b.putString("type", "Public");
                intent.putExtras(b);
                startActivityForResult(intent, 5);
                break;
            case "m2":
                //Benifairo
                intent = new Intent(Maps_Towns.this, Maps_Schools.class);
                b = new Bundle();
                b.putInt("town", 3);
                b.putString("type", "Public");
                intent.putExtras(b);
                startActivityForResult(intent, 5);
                break;
        }
        return false;
    }

}
