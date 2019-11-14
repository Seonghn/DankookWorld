package com.example.dankookworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Context;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c_register extends AppCompatActivity {
    private ArrayList<ClipData.Item> list;
    public static c_register mContext;
    EditText name1, phone1, cbirth, address1, cname;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_register);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        name1 = findViewById(R.id.name1);
        phone1 = findViewById(R.id.phone1);
        cbirth = findViewById(R.id.cbirth);
        address1 = findViewById(R.id.address1);
        cname = findViewById(R.id.cname);



        Button submit = findViewById(R.id.submit);
        Intent intent = getIntent();
        final String qrresult = intent.getExtras().getString("qrresult");


      //  progressDialog = new ProgressDialog(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> dataToSave = new HashMap<>();
                dataToSave.put("주소", address1.getText().toString());
                dataToSave.put("아이생일", cbirth.getText().toString());
                dataToSave.put("이름", name1.getText().toString());
                dataToSave.put("전화번호", phone1.getText().toString());
                dataToSave.put("아이이름", cname.getText().toString());
                if(qrresult != null) {
                    firebaseFirestore.collection("qrcode").document(qrresult).set(dataToSave);
                    finish();
                    Toast.makeText(getApplicationContext(), "등록되었습니다.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "등록에 실패하였습니다.", Toast.LENGTH_LONG).show();
                }

               // startActivity(new Intent(getApplicationContext(), C_finder.class));

            }
        });

        }
    /*public void qr_null(){
        mContext = this;
        Map<String, Object> dataToSave = new HashMap<>();
        dataToSave.put("주소","");
        dataToSave.put("아이생일", "");
        dataToSave.put("이름", "");
        dataToSave.put("전화번호", "");
        dataToSave.put("아이이름", "");
        firebaseFirestore.collection("qrcode").document(qrresult).set(dataToSave);
        finish();
        Toast.makeText(getApplicationContext(), "초기화 되었습니다..", Toast.LENGTH_LONG).show();


    }*/
    }

