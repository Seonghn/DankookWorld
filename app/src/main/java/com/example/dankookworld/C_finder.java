package com.example.dankookworld;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

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
    SmsManager mSMSManager;
    private LocationManager locationManager;
    private static final int REQUEST_CODE_LOCATION = 2;
    private boolean isPermission = false;
    private final int PERMISSIONS_ACCESS_FINE_LOCATION = 1000;
    private final int PERMISSIONS_ACCESS_COARSE_LOCATION = 1001;
    private GpsInfo gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_find);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        mSMSManager = SmsManager.getDefault();

        startQRCode();
        Button transmit =  findViewById(R.id.transmit);
        transmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // 권한 요청을 해야 함
                if (!isPermission) {
                    callPermission();
                    return;
                }

                gps = new GpsInfo(C_finder.this);
                // GPS 사용유무 가져오기
                if (gps.isGetLocation()) {

                    final double latitude = gps.getLatitude();
                    final double longitude = gps.getLongitude();

                    if (firebaseAuth != null) {
                        DocumentReference docRef = firebaseFirestore.collection("qrcode").document(qrresult);
                        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document != null) {
                                        String  phoneNo  = document.getString("전화번호");
                                        String sms = "현재 아이를 보호하고 있습니다."+"위치는 http://maps.google.com/?q="+latitude+","+longitude;

                                        // 우선 메세지함으로 이동해서 보낼지말지는 사용자가 결정
//                                        Intent intent = new Intent(Intent.ACTION_SENDTO);
//                                        Uri uri = Uri.parse("sms:" + phoneNo);
//                                        intent.setData(uri);
//                                        intent.putExtra("sms_body", sms);
//                                        startActivity(intent);
//                                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                                        intent.putExtra("lat", latitude);
//                                        intent.putExtra("lon", longitude);
//                                        startActivity(intent);
                                        SendSMS(phoneNo,sms); // SendSms를 이용하여 문자보내기 시도중..
                                    }
                                }
                            }
                        });
                    }

                } else {
                    // GPS 를 사용할수 없으므로
                    gps.showSettingsAlert();
                }
            }
        });

        callPermission();  // 권한 요청을 해야 함

        gps = new GpsInfo(C_finder.this);
    }
    private void callPermission() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_ACCESS_FINE_LOCATION);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){

            requestPermissions(
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    PERMISSIONS_ACCESS_COARSE_LOCATION);
        } else {
            isPermission = true;
        }
    }

    public void startQRCode() {
        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false); // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        qrScan.setPrompt("QR 코드를 스캔해주세요 !");
        qrScan.initiateScan();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final TextView phonetext = findViewById(R.id.phonetext);
        final TextView addresstext = findViewById(R.id.addresstext);
        final TextView nametext = findViewById(R.id.nametext);
        final TextView cname = findViewById(R.id.cname1);
        final TextView cage = findViewById(R.id.cage);

        //Intent intent = new Intent(this, c_register.class);

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
                                    cage.setText(document.getString("아이나이"));
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

    public void SendSMS(String number, String msg) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
            Toast.makeText(this, "권한을 허용하고 재전송해주세요", Toast.LENGTH_LONG).show();
        } else {
            try {
                //전송
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number, null, msg, null, null);
                Toast.makeText(getApplicationContext(), "전송 완료!", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SMS faild, please try again later!", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    }







}

