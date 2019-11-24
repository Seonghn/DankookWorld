package com.example.dankookworld.ui.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dankookworld.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SettingFragment extends Fragment {
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        final EditText name, phone, birth, address, insertpwd, insertpwdd;
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        birth = view.findViewById(R.id.birth);
        address = view.findViewById(R.id.address);
        insertpwd = view.findViewById(R.id.insertPwd);
        insertpwdd = view.findViewById(R.id.insertPwdd);
        Button button = view.findViewById(R.id.button123);
        final TextView insertid = view.findViewById(R.id.insertId);

        //button.setOnClickListener(view.);


        if (firebaseAuth.getCurrentUser() != null) {
            final String userI = firebaseAuth.getCurrentUser().getEmail();
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
            @Override
            public void onClick(View v) {
                Map<String, Object> dataToSave = new HashMap<>();
                dataToSave.put("Address", address.getText().toString());
                dataToSave.put("Birth", birth.getText().toString());
                dataToSave.put("Name", name.getText().toString());
                dataToSave.put("Phone", phone.getText().toString());
               // String passwd1 = insertpwd.getText().toString();
                //String passwd2 = insertpwdd.getText().toString();
                Toast.makeText(getContext(),"hi",Toast.LENGTH_LONG);
            }
        });

            //Debug.Log("Password updated successfully.");
       /* button.setOnClickListener(new View.OnClickListener() {
            String passwd1 = insertpwd.getText().toString();

            String passwd2 = insertpwdd.getText().toString();
            @Override
            public void onClick(View v) {
                /*if(passwd1 == passwd2){
                    user.updatePassword(passwd1);
                    Toast.makeText(getContext(),"성공헀습니다.",Toast.LENGTH_LONG);
                }else{
                    Toast.makeText(getContext(),"실패했습니다.",Toast.LENGTH_LONG);
                }

                Toast.makeText(getContext(),passwd1,Toast.LENGTH_LONG);


            }
        }); */


        return  view;
    }
}







