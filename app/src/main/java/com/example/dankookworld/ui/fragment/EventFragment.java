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
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.dankookworld.MyListAdapter_event;
import com.example.dankookworld.Notice_itemList;
import com.example.dankookworld.R;
import com.example.dankookworld.event1Activity;
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

    private Context context;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListView listView;
    com.example.dankookworld.MyListAdapter MyListAdapter;
    ArrayList<Notice_itemList> list_itemArrayList;

    public String event = "event";
    public String event1_title, event1_time, event1_loc;
    public String event2_title, event2_time, event2_loc;
    public String event3_title, event3_time, event3_loc;
    public String event4_title, event4_time, event4_loc;
    public String event5_title, event5_time, event5_loc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event, container, false);
        context = container.getContext();

        final ListView listView = (ListView) view.findViewById(R.id.eventList);

        list_itemArrayList = new ArrayList<Notice_itemList>();

        DocumentReference docRef = db.collection("이벤트").document("이벤트1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        event1_title = document.getString("제목");
                        event1_time = document.getString("날짜");
                        event1_loc = document.getString("장소");

                        Notice_itemList n1 =  new Notice_itemList(R.drawable.dancebattle, event, event1_title , event1_time, event1_loc);
                        list_itemArrayList.add(n1);

                        listView.setAdapter(new MyListAdapter_event(getActivity(), list_itemArrayList));


                    }
                }
            }
        });

        //event2
        DocumentReference docRef2 = db.collection("이벤트").document("이벤트2");
        docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        event2_title = document.getString("제목");
                        event2_time = document.getString("날짜");
                        event2_loc = document.getString("장소");

                        Notice_itemList n2 =  new Notice_itemList(R.drawable.firework, event, event2_title , event2_time, event2_loc);
                        list_itemArrayList.add(n2);

                        listView.setAdapter(new MyListAdapter_event(getActivity(), list_itemArrayList));


                    }
                }
            }
        });
        //event3
        DocumentReference docRef3 = db.collection("이벤트").document("이벤트3");
        docRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        event3_title = document.getString("제목");
                        event3_time = document.getString("날짜");
                        event3_loc = document.getString("장소");

                        Notice_itemList n3 = new Notice_itemList(R.drawable.shopping, event, event3_title, event3_time, event3_loc);
                        list_itemArrayList.add(n3);

                        listView.setAdapter(new MyListAdapter_event(getActivity(), list_itemArrayList));


                    }
                }
            }
        });
        //event4
        DocumentReference docRef4 = db.collection("이벤트").document("이벤트4");
        docRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        event4_title = document.getString("제목");
                        event4_time = document.getString("날짜");
                        event4_loc = document.getString("장소");

                        Notice_itemList n4 = new Notice_itemList(R.drawable.store4, event, event4_title, event4_time, event4_loc);
                        list_itemArrayList.add(n4);

                        listView.setAdapter(new MyListAdapter_event(getActivity(), list_itemArrayList));


                    }
                }
            }
        });
        // event5
        DocumentReference docRef5 = db.collection("이벤트").document("이벤트5");
        docRef5.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        event5_title = document.getString("제목");
                        event5_time = document.getString("날짜");
                        event5_loc = document.getString("장소");

                        Notice_itemList n5 = new Notice_itemList(R.drawable.suneung, event, event5_title, event5_time, event5_loc);
                        list_itemArrayList.add(n5);

                        listView.setAdapter(new MyListAdapter_event(getActivity(), list_itemArrayList));


                    }
                }
            }
        });

        //클릭이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), event1Activity.class);
                intent.putExtra("profile", Integer.toString(list_itemArrayList.get(position).getProfile_image()));
                intent.putExtra("name", list_itemArrayList.get(position).getTitle());
                intent.putExtra("time", list_itemArrayList.get(position).getWrite_date());
                intent.putExtra("location", list_itemArrayList.get(position).getContent());

                startActivity(intent);
            }
        });

        return  view;

    }
}
