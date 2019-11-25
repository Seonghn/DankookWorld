package com.example.dankookworld.ui.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dankookworld.MyListAdapter;
import com.example.dankookworld.Notice_itemList;
import com.example.dankookworld.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NoticeFragment extends Fragment {

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    ListView listView;
    com.example.dankookworld.MyListAdapter MyListAdapter;
    ArrayList<Notice_itemList> list_itemArrayList;

    public String notice1_title, notice1_time;
    public String notice2_title, notice2_time;
    public String notice3_title, notice3_time;
    public String notice4_title, notice4_time;
    public String notice5_title, notice5_time;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        final ListView listView = (ListView) view.findViewById(R.id.noticeList);
        list_itemArrayList = new ArrayList<Notice_itemList>();

        DocumentReference doc = firebaseFirestore.collection("공지사항").document("공지1");
        doc.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        notice1_title = document.getString("제목");
                        notice1_time = document.getString("날짜");

                        list_itemArrayList.add(
                                new Notice_itemList(R.drawable.mini," 안내",notice1_title, notice1_time," "));
                        listView.setAdapter(new MyListAdapter(getActivity(), list_itemArrayList));
                    }
                }
            }
        });

        DocumentReference doc2 = firebaseFirestore.collection("공지사항").document("공지2");
        doc2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        notice2_title = document.getString("제목");
                        notice2_time = document.getString("날짜");

                        list_itemArrayList.add(
                                new Notice_itemList(R.drawable.mini," 안내",notice2_title, notice2_time," "));
                        listView.setAdapter(new MyListAdapter(getActivity(), list_itemArrayList));
                    }
                }
            }
        });

        DocumentReference doc3 = firebaseFirestore.collection("공지사항").document("공지3");
        doc3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        notice3_title = document.getString("제목");
                        notice3_time = document.getString("날짜");

                        list_itemArrayList.add(
                                new Notice_itemList(R.drawable.mini," 공지",notice3_title, notice3_time," "));
                        listView.setAdapter(new MyListAdapter(getActivity(), list_itemArrayList));
                    }
                }
            }
        });

        DocumentReference doc4 = firebaseFirestore.collection("공지사항").document("공지4");
        doc4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        notice4_title = document.getString("제목");
                        notice4_time = document.getString("날짜");

                        list_itemArrayList.add(
                                new Notice_itemList(R.drawable.mini," 안내",notice4_title, notice4_time," "));
                        listView.setAdapter(new MyListAdapter(getActivity(), list_itemArrayList));
                    }
                }
            }
        });

        DocumentReference doc5 = firebaseFirestore.collection("공지사항").document("공지5");
        doc5.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        notice5_title = document.getString("제목");
                        notice5_time = document.getString("날짜");

                        list_itemArrayList.add(
                                new Notice_itemList(R.drawable.mini," 안내",notice5_title, notice5_time," "));
                        listView.setAdapter(new MyListAdapter(getActivity(), list_itemArrayList));
                    }
                }
            }
        });

        return  view;

    }
}
