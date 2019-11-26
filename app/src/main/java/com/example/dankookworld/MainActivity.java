package com.example.dankookworld;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

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
/*
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_main2, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
*/

}
