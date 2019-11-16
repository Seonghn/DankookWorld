package com.example.dankookworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Context;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class c_register extends AppCompatActivity {
    private ArrayList<ClipData.Item> list;
    public static c_register mContext;
    EditText name1, phone1, cbirth, address1, cname;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;
    int year, month, day ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_register);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        name1 = findViewById(R.id.name1);
        phone1 = findViewById(R.id.phone1);
        phone1.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        cbirth = findViewById(R.id.cbirth);
        address1 = findViewById(R.id.address1);
        cname = findViewById(R.id.cname);


        Button submit = findViewById(R.id.submit);

        Intent intent = getIntent();
        final String qrresult = intent.getExtras().getString("qrresult");
        cbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DateSet();

            }
        });

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
                if (qrresult != null) {
                    firebaseFirestore.collection("qrcode").document(qrresult).set(dataToSave);
                    finish();
                    Toast.makeText(getApplicationContext(), "등록되었습니다.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "등록에 실패하였습니다.", Toast.LENGTH_LONG).show();
                }

                // startActivity(new Intent(getApplicationContext(), C_finder.class));

            }
        });

    }
    /*public static void HideKeyboard(Activity activity){
        InputMethodManager im = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),0);
    }*/
    private void DateSet(){
        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                String resultBirthday = year +"."+ String.format("%02d",monthOfYear+1) +"."+ String.format("%02d",dayOfMonth) ;
                cbirth.setText(resultBirthday);

            }
        };
        Calendar calendar1 = Calendar.getInstance();
        year = calendar1.get(Calendar.YEAR);
        month = calendar1.get(Calendar.MONTH);
        day = calendar1.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dateDialog = new DatePickerDialog(this, callback, year, month, day);
        dateDialog.show();
    }
}

