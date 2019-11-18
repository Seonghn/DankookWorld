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
import android.widget.AdapterView;

import com.example.dankookworld.MyListAdapter_event;
import com.example.dankookworld.Notice_itemList;
import com.example.dankookworld.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventFragment extends Fragment {

    ListView listView;
    com.example.dankookworld.MyListAdapter MyListAdapter;
    ArrayList<Notice_itemList> list_itemArrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event, container, false);

        ListView listView = (ListView) view.findViewById(R.id.eventList);

        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
        Date time = new Date();
        String time1 = format1.format(time);

        list_itemArrayList = new ArrayList<Notice_itemList>();
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.dancebattle," evnt1"," 유령들의 댄스배틀",time1," 자이로스윙 앞"));
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
