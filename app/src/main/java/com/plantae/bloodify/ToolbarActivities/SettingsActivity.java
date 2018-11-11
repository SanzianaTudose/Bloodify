package com.plantae.bloodify.ToolbarActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.plantae.bloodify.MainActivity;
import com.plantae.bloodify.QRCodeActivity;
import com.plantae.bloodify.R;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;

public class SettingsActivity extends AppCompatActivity {

    MultiStateToggleButton toggleGrupa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    public void launchQRCodeActivity(View view) {
        Intent intent = new Intent(this, QRCodeActivity.class);
        startActivity(intent);
    }
}
