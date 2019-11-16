package com.example.dankookworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
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
        String mNumber = intent.getStringExtra("mNumber");
        String[] d = mNumber.split("m");
        String viewID = ""+ mfNum + d[1];
//        int resID = getResources().getIdentifier(viewID,"drawable", getCallingActivity().getPackageName());

        switch (mfNum) {
            case "wait":
                setContentView(R.layout.wait);
                ImageView imageView = findViewById(R.id.waitImage);
//                imageView.setImageResource(resID);
                TextView textView = findViewById(R.id.res1_name);
                textView.setText(viewID);
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
//        if (firebaseAuth.getCurrentUser() != null) {
//            String userI = firebaseAuth.getCurrentUser().getEmail();
//            DocumentReference docRef = firebaseFirestore.collection("user").document(userI);
//            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                    if (task.isSuccessful()) {
//                        DocumentSnapshot document = task.getResult();
//                        if (document != null) {
//                            userName.setText(document.getString("Name"));
//                        }
//                    }
//                }
//            });
        }

    }
//
//    public void fetchDB_map(String )

