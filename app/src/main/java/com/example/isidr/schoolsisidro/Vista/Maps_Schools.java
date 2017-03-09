package com.example.isidr.schoolsisidro.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.isidr.schoolsisidro.Control.MainMenu;
import com.example.isidr.schoolsisidro.R;
import com.example.isidr.schoolsisidro.Control.SQLite_Towns_and_schools;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps_Schools extends MainMenu implements OnMapReadyCallback {

    private GoogleMap mMap;
    SQLite_Towns_and_schools connexion;
    SQLiteDatabase db;
    int town;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps__schools);

        //Recollir dades per a filtrar els resultats
        Bundle bundle = this.getIntent().getExtras();
        town = bundle.getInt("town");
        type = bundle.getString("type");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Obrir laconexió amb base de dades
        connexion = new SQLite_Towns_and_schools(this);
        db = connexion.getWritableDatabase();
        //Declarar el marcador i la posicio de este
        Marker marker;
        LatLng posicio;
        //Recollint dades de la base de dades
        Cursor c = db.rawQuery("SELECT Name, Lat, Lon FROM Schools WHERE Kind_of_School = '"+type+ "' and Town = "+town, null);
        if (c.moveToFirst()) {
            do {
                String name = c.getString(0);
                double lat = c.getDouble(1);
                double lon = c.getDouble(2);
                posicio = new LatLng(lat, lon);
                marker = mMap.addMarker(new MarkerOptions()
                        .position(posicio).title(name).snippet(type+" School"));

            } while (c.moveToNext());
        }

        if (town == 1) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.0699521, -0.2680663), 14));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
        }
        else if (town == 2) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.0436023, -0.3100889), 15));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        }
        else if (town == 3) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.0540847, -0.3031696), 15));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        }


    }
}
