package com.example.dankookworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dankookworld.ui.map.map;

public class mapActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity2_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, map.newInstance())
                    .commitNow();
        }
    }
}
