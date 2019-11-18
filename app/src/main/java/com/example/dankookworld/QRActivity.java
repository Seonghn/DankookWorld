package com.example.dankookworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class QRActivity extends AppCompatActivity {

// 초기화 버튼 구현 요망

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    private IntentIntegrator qrScan;
    String qrresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        //startQRCode();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        findViewById(R.id.qr_identify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =  new Intent(getApplicationContext(), C_finder.class);
               startActivity(intent);
            }
        });


        findViewById(R.id.qr_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQRCode();
            }
        });
        findViewById(R.id.qr_adjust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQRCode();
            }
        });
        findViewById(R.id.qr_null).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), InitialActivity.class);
                startActivity(intent);
            }
        });
    }

    public void startQRCode() {
        qrScan = new IntentIntegrator(this);
        qrScan.setBeepEnabled(false);
        qrScan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        qrScan.setPrompt("QR 코드를 스캔해주세요 !");
        qrScan.initiateScan();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

          Intent intent = new Intent(this, c_register.class);


        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            qrresult = result.getContents();
            if (qrresult != null) {
                Toast.makeText(this, "스캔되었습니다." , Toast.LENGTH_LONG).show();
                intent.putExtra("qrresult", qrresult);
                startActivity(intent);
            } else {
                    Toast.makeText(this, "스캔에 실패하였습니다.", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

}
