package com.example.dankookworld.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.dankookworld.MyListAdapter_event;
import com.example.dankookworld.Notice_itemList;
import com.example.dankookworld.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listView;
    com.example.dankookworld.MyListAdapter MyListAdapter;
    ArrayList<Notice_itemList> list_itemArrayList;

    private String event1;
    private String event2;
    private String event3;
    private String event4;
    private String event5;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event, container, false);

        ListView listView = (ListView) view.findViewById(R.id.eventList);

        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
        Date time = new Date();
        String time1 = format1.format(time);

        DocumentReference docRef = db.collection("이벤트").document("이벤트1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        event1 = document.getString("제목");

                    }
                }
            }
        });
/*
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
*/

        list_itemArrayList = new ArrayList<Notice_itemList>();
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.dancebattle," event1", event1 ,time1," 자이로스윙 앞"));
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.store2," event2"," 제목2",time1," 내용2"));
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.store3," event3"," 제목3",time1," 내용3"));
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.store4," event4"," 제목4",time1," 내용4"));
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.store5," event5"," 제목5",time1," 내용5"));

        listView.setAdapter(new MyListAdapter_event(getActivity(), list_itemArrayList));

        return  view;

    }
}
