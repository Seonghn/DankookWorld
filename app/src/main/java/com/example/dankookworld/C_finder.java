package com.example.dankookworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class C_finder extends AppCompatActivity {

    private IntentIntegrator qrScan;
    String qrresult;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_find);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        startQRCode();

    }

    public void startQRCode() {
        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        qrScan.setPrompt("QR 코드를 스캔해주세요 !");
        qrScan.initiateScan();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Intent intent = new Intent(this, c_register.class);
        final TextView phonetext = findViewById(R.id.phonetext);
        final TextView addresstext = findViewById(R.id.addresstext);
        final TextView nametext = findViewById(R.id.nametext);
        final TextView cname = findViewById(R.id.cname1);

        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            qrresult = result.getContents();
            if (qrresult != null) {
                if (firebaseAuth != null) {
                    DocumentReference docRef = firebaseFirestore.collection("qrcode").document(qrresult);
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document != null) {
                                    phonetext.setText(document.getString("전화번호"));
                                    cname.setText(document.getString("아이이름"));
                                    addresstext.setText(document.getString("주소"));
                                    nametext.setText(document.getString("이름"));

                                }
                            }
                        }
                    });
                    Toast.makeText(this, "스캔되었습니다.", Toast.LENGTH_LONG).show();
                }
            }else {
                    Toast.makeText(this, "스캔에 실패하였습니다.", Toast.LENGTH_LONG).show();
                    finish();
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }

    }

