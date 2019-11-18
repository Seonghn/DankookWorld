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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NoticeFragment extends Fragment {

    ListView listView;
    com.example.dankookworld.MyListAdapter MyListAdapter;
    ArrayList<Notice_itemList> list_itemArrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        ListView listView = (ListView) view.findViewById(R.id.noticeList);

        SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        String time1 = format1.format(time);

        list_itemArrayList = new ArrayList<Notice_itemList>();
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.mini," 공지1"," 제목1",time1," 내용1"));
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.mini," 공지2"," 제목2",time1," 내용2"));
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.mini," 공지3"," 제목3",time1," 내용3"));
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.mini," 공지4"," 제목4",time1," 내용4"));
        list_itemArrayList.add(
                new Notice_itemList(R.drawable.mini," 공지5"," 제목5",time1," 내용5"));

        listView.setAdapter(new MyListAdapter(getActivity(), list_itemArrayList));

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        */

        return  view;

    }
}
