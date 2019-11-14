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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c_register extends AppCompatActivity {
    private ArrayList<ClipData.Item> list;
    EditText name1, phone1, cbirth, address1, cname;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;
    String Name, Phone, Cbirth, Address, Cname;

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



        progressDialog = new ProgressDialog(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> dataToSave = new HashMap<>();
                dataToSave.put("주소", address1.getText().toString());
                dataToSave.put("아이생일", cbirth.getText().toString());
                dataToSave.put("이름", name1.getText().toString());
                dataToSave.put("전화번호", phone1.getText().toString());
                dataToSave.put("아이이름", cname.getText().toString());
                firebaseFirestore.collection("qrcode").document(qrresult).set(dataToSave);
                finish();
                Toast.makeText(getApplicationContext(), "등록되었습니다.", Toast.LENGTH_LONG).show();
               // startActivity(new Intent(getApplicationContext(), C_finder.class));

            }
        });

    }
}


/*
    private ArrayList<ClipData.Item> list;
    EditText name1, phone1, cbirth, address1, cname;
    Button submit;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;
    String Name, Phone, Cbirth, Address, Cname;
    Intent intent = getIntent();
    String qrresult = intent.getStringExtra("qrresult");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_register);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
//        if(firebaseAuth.getCurrentUser() != null){
//            finish();
//            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//        }

        name1 = findViewById(R.id.name1);
        phone1 = findViewById(R.id.phone1);
        cbirth = findViewById(R.id.cbirth);
        address1 = findViewById(R.id.address1);
        cname = findViewById(R.id.cname);


        Button register = findViewById(R.id.submit);




        progressDialog = new ProgressDialog(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> dataToSave = new HashMap<>();
                dataToSave.put("주소", address1.getText().toString());
                dataToSave.put("아이생일", cbirth.getText().toString());
                dataToSave.put("이름", name1.getText().toString());
                dataToSave.put("전화번호", phone1.getText().toString());
                dataToSave.put("아이이름", cname.getText().toString());
                firebaseFirestore.collection("qrcode").document(qrresult).set(dataToSave);
                finish();
                startActivity(new Intent(getApplicationContext(), C_finder.class));

            }
        });


    }
*/
/*
    private void registerUser() {
       // String makeId = insertId.getText().toString().trim();
      //  String makePwd = insertPwd.getText().toString().trim();

        progressDialog.setMessage("회원가입 중입니다.");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(makeId, makePwd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
//                    String u1 = firebaseAuth.getUid();
//                    String email = insertId.getText().toString();
                   // String email = insertId.getText().toString();
                    Map<String, Object> dataToSave = new HashMap<>();
                    dataToSave.put("주소", address1.getText().toString());
                    dataToSave.put("아이생일", cbirth.getText().toString());
                    dataToSave.put("이름", name1.getText().toString());
                    dataToSave.put("전화번호", phone1.getText().toString());
                    dataToSave.put("아이이름", cname.getText().toString());
                    firebaseFirestore.collection("qrcode").document(qrresult).set(dataToSave);
                    finish();
                    startActivity(new Intent(getApplicationContext(), C_finder.class));
                } else {
                    Toast.makeText(c_register.this, "가입하실 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });}*/
