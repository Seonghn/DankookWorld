package com.example.dankookworld;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    Button loginyes, loginno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        loginyes = findViewById(R.id.loginyes);
        loginno = findViewById(R.id.loginno);

        loginyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yesintent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(yesintent);
            }
        });

        loginno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nointent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(nointent);
            }
        });
    }
}
