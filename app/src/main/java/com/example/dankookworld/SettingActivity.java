package com.example.dankookworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SettingActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_setting);
        final EditText name, phone, birth, address, insertpwd, insertpwdd;
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        birth = findViewById(R.id.birth);
        address = findViewById(R.id.address);
        insertpwd = findViewById(R.id.insertPwd);
        insertpwdd =findViewById(R.id.insertPwdd);
        Button button = findViewById(R.id.button123);
        final TextView insertid = findViewById(R.id.insertId);
        final String userI = firebaseAuth.getCurrentUser().getEmail();
        if (firebaseAuth.getCurrentUser() != null) {

            DocumentReference docRef = firebaseFirestore.collection("user").document(userI);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null) {
                            phone.setText(document.getString("Phone"));
                            birth.setText(document.getString("Birth"));
                            address.setText(document.getString("Address"));
                            name.setText(document.getString("Name"));
                            insertid.setText(userI);
                        }

                    }
                }
            });
        }
        button.setOnClickListener(new View.OnClickListener() {

                String passwd1 = insertpwd.getText().toString();

                String passwd2 = insertpwdd.getText().toString();
                @Override
                public void onClick(View v) {
                    Map<String, Object> dataToSave = new HashMap<>();
                    dataToSave.put("Address", address.getText().toString());
                    dataToSave.put("Birth", birth.getText().toString());
                    dataToSave.put("Name", name.getText().toString());
                    dataToSave.put("Phone", phone.getText().toString());

                        if (userI != null) {
                            firebaseFirestore.collection("user").document(userI).set(dataToSave);
                            finish();
                            //FirebaseAuth.getInstance().getCurrentUser().send
                            // E

                            //일반 정보는 업데이트 가능하지만 비밀번호 업데이트 아직 불가능.
                            Toast.makeText(getApplicationContext(), "등록되었습니다.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "등록에 실패하였습니다.", Toast.LENGTH_LONG).show();
                        }




                }

        });




        }
    }

