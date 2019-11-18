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

        list_itemArrayList = new ArrayList<Notice_itemList>();
        list_itemArrayList.add(
                new Notice_itemList(R.mipmap.ic_launcher," [공지1]"," 제목1",new Date(System.currentTimeMillis())," 내용1"));
        list_itemArrayList.add(
                new Notice_itemList(R.mipmap.ic_launcher," [공지2]"," 제목2",new Date(System.currentTimeMillis())," 내용2"));
        list_itemArrayList.add(
                new Notice_itemList(R.mipmap.ic_launcher," [공지3]"," 제목3",new Date(System.currentTimeMillis())," 내용3"));
        list_itemArrayList.add(
                new Notice_itemList(R.mipmap.ic_launcher," [공지4]"," 제목4",new Date(System.currentTimeMillis())," 내용4"));
        list_itemArrayList.add(
                new Notice_itemList(R.mipmap.ic_launcher," [공지5]"," 제목5",new Date(System.currentTimeMillis())," 내용5"));

        listView.setAdapter(new MyListAdapter(getActivity(), list_itemArrayList));

        return  view;

    }
}
