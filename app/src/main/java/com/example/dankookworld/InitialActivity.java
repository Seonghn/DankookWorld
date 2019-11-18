package com.example.dankookworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;


public class InitialActivity extends Activity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    private IntentIntegrator qrScan;
    String qrresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        startQRCode();
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

        //Intent intent = new Intent(this, c_register.class);
        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            qrresult = result.getContents();
            if (qrresult != null) {
                Toast.makeText(this, "스캔되었습니다.", Toast.LENGTH_LONG).show();
                Map<String, Object> dataToSave = new HashMap<>();
                dataToSave.put("주소", "");
                dataToSave.put("아이생일", "");
                dataToSave.put("이름", "");
                dataToSave.put("전화번호", "");
                dataToSave.put("아이이름", "");


                if (firebaseAuth != null) {
                    firebaseFirestore.collection("qrcode").document(qrresult).set(dataToSave);
                    finish();
                    Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_LONG).show();
                    }
            }else {
                Toast.makeText(this, "스캔에 실패하였습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }


        /*if (requestCode == IntentIntegrator.REQUEST_CODE) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            qrresult = result.getContents();
            if (qrresult != null) {
                Toast.makeText(this, "스캔되었습니다.", Toast.LENGTH_LONG).show();
                Map<String, Object> dataToSave = new HashMap<>();
                dataToSave.put("주소", "");
                dataToSave.put("아이생일", "");
                dataToSave.put("이름", "");
                dataToSave.put("전화번호", "");
                dataToSave.put("아이이름", "");
                    if (qrresult != null) {
                        firebaseFirestore.collection("qrcode").document(qrresult).set(dataToSave);
                        finish();
                        Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "초기화에 실패하였습니다.", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),QRActivity.class));
                    }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }

        }
    }*/
}