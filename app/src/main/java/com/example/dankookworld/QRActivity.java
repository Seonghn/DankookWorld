package com.example.dankookworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import androidx.appcompat.app.AppCompatActivity;

public class QRActivity extends AppCompatActivity {
    private IntentIntegrator qrScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        //startQRCode();
        findViewById(R.id.qr_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQRCode();
            }
        });

    }

    public void startQRCode() {
        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        qrScan.setPrompt("QR 코드를 스캔해주세요 !");
        qrScan.initiateScan();
    }


    // private FirebaseAuth firebaseAuth;
    // private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {




       /* if(firebaseAuth.getCurrentUser() != null){
            String qr = firebaseAuth.getCurrentUser().getEmail();
            DocumentReference docRef = firebaseFirestore.collection("qrcode").document(qr);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null) {
                            userName.setText(document.getString("Name"));
                        }
                    }
                }
        });
        userEmail.setText(userI);
    }*/
        Intent intent = new Intent(this, c_register.class);

        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            String qrresult = result.getContents();
            if (result == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();


            } else {

                Toast.makeText(this, "Scanned: " + qrresult, Toast.LENGTH_LONG).show();
                intent.putExtra("qrresult",qrresult);
                startActivity(intent);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
