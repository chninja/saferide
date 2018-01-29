package com.example.ssilance.saferide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.zxing.WriterException;

import org.json.JSONObject;

import java.io.FileInputStream;

/**
 * Created by Sacha on 2018-01-27.
 */

public class RiderMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String addressString = PreferenceManager.
                            getDefaultSharedPreferences(getApplicationContext()).getString("ADDRESS","");
                    Toast.makeText(getApplicationContext(), addressString,
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rider, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.profileSettingsItem){
            Intent intent = new Intent(RiderMainActivity.this, ProfileSettingsActivity.class);
            startActivity(intent);
            return true;
        } else if(item.getItemId() == R.id.showQRCodeItem){
            Intent intent = new Intent(RiderMainActivity.this, GenerateQRCodeActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
