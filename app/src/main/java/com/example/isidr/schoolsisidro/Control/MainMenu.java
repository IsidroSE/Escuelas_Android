package com.example.isidr.schoolsisidro.Control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.isidr.schoolsisidro.R;
import com.example.isidr.schoolsisidro.Vista.MainActivity;
import com.example.isidr.schoolsisidro.Vista.Maps_Towns;

/**
 * Created by Isidro on 23/11/2015.
 */

public class MainMenu extends AppCompatActivity {


    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.mMap:
                goToMaps();
                break;
            case R.id.mMain:
                goToMain();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToMaps() {
        Intent intent = new Intent(MainMenu.this, Maps_Towns.class);
        startActivity(intent);
    }

    private void goToMain() {
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        startActivity(intent);
    }

}
