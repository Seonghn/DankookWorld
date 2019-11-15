package com.example.dankookworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();

        String mfNum = intent.getStringExtra("mfN");
        String name = intent.getStringExtra("id");

        switch (mfNum){
            case "wait":
                setContentView(R.layout.wait);
                TextView textView = findViewById(R.id.res1_name);
                textView.setText(name);
                break;


            case "info":
                setContentView(R.layout.info);
                TextView textView2 = findViewById(R.id.res2_name);
                textView2.setText(name);
                break;


            case "food":
                setContentView(R.layout.food);
                TextView textView3 = findViewById(R.id.res3_name);
                textView3.setText(name);
                break;


            case "store":
                setContentView(R.layout.store);
                TextView textView4 = findViewById(R.id.res4_name);
                textView4.setText(name);
                break;
        }

    }
}
