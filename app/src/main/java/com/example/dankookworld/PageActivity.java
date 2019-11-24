package com.example.dankookworld;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class PageActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();

        String mfNum = intent.getStringExtra("mfN");
        String name = intent.getStringExtra("id");
        String mNumber = intent.getStringExtra("mNumber");
        String[] d = mNumber.split("m");
        String viewID = ""+ mfNum + d[1];
        int resID = getResources().getIdentifier(viewID,"drawable", getPackageName());

        switch (mfNum) {
            case "wait":
                setContentView(R.layout.wait);
                ImageView imageView = findViewById(R.id.waitImage);
                imageView.setImageResource(resID);
                TextView textView = findViewById(R.id.res1_name);
                textView.setText(name);
                final TextView waitT1 = findViewById(R.id.waitT1);
                final TextView waitT2 = findViewById(R.id.waitT2);
                final TextView waitT3 = findViewById(R.id.waitT3);
                final TextView waitT4 = findViewById(R.id.waitT4);

                DocumentReference docRef = firebaseFirestore.collection("놀이기구").document(name);
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                waitT1.setText(document.getString("대기시간"));
                                waitT2.setText(document.getString("운행시간"));
                                waitT3.setText(document.getString("탑승제한_연령"));
                                waitT4.setText(document.getString("탑승제한_키"));
                            }
                        }
                    }
                });
                break;


            case "info":
                setContentView(R.layout.info);
                ImageView imageView2 = findViewById(R.id.infoImage);
                imageView2.setImageResource(resID);
                TextView textView2 = findViewById(R.id.res2_name);
                textView2.setText(name);
                final TextView info1 = findViewById(R.id.info1);
                final TextView info2 = findViewById(R.id.info2);
                final TextView info3 = findViewById(R.id.info3);
                DocumentReference docRef2 = firebaseFirestore.collection("편의시설").document(name);
                docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                info1.setText(document.getString("제공 서비스"));
                                info2.setText(document.getString("운영 시간"));
                                info3.setText(document.getString("전화번호"));
                                                          }
                        }
                    }
                });
                break;


            case "food":
                setContentView(R.layout.food);
                ImageView imageView3 = findViewById(R.id.foodImage);
                imageView3.setImageResource(resID);
                TextView textView3 = findViewById(R.id.res3_name);
                textView3.setText(name);

                final TextView food1 = findViewById(R.id.food1);
                final TextView food2 = findViewById(R.id.food2);
                final TextView food3 = findViewById(R.id.food3);
                DocumentReference docRef3 = firebaseFirestore.collection("음식점").document(name);
                docRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                food1.setText(document.getString("대표메뉴"));
                                food2.setText(document.getString("운영시간"));
                                food3.setText(document.getString("전화번호"));
                            }
                        }
                    }
                });
                break;


            case "store":
                setContentView(R.layout.store);
                ImageView imageView4 = findViewById(R.id.storeImage);
                imageView4.setImageResource(resID);
                TextView textView4 = findViewById(R.id.res4_name);
                textView4.setText(name);

                final TextView store1 = findViewById(R.id.store1);
                final TextView store2 = findViewById(R.id.store2);
                final TextView store3 = findViewById(R.id.store3);
                DocumentReference docRef4 = firebaseFirestore.collection("상점").document(name);
                docRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null) {
                                store1.setText(document.getString("설명"));
                                store2.setText(document.getString("운영시간"));
                                store3.setText(document.getString("전화번호"));
                            }
                        }
                    }
                });
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

