package com.example.dankookworld;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class event1Activity extends AppCompatActivity {

    private int img;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);

        Intent intent = getIntent();

        ImageView profile = (ImageView) findViewById(R.id.event1_image);
        TextView nickname = (TextView) findViewById(R.id.event1_nickname);
        TextView loc = (TextView) findViewById(R.id.event1_loc);
        TextView time = (TextView) findViewById(R.id.event1_time);

        img = Integer.parseInt(intent.getStringExtra("profile"));
        profile.setImageResource(img);
        nickname.setText(intent.getStringExtra("name"));
        loc.setText(intent.getStringExtra("location"));
        time.setText(intent.getStringExtra("time"));

    }
}
