package com.example.dankookworld.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dankookworld.R;

public class MapFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_map, container, false);
        getFragmentManager().beginTransaction().add(R.id.mapFrame, new MapFragment_wait()).commit();
        ImageButton wtB = view.findViewById(R.id.wtB);
        ImageButton atB = view.findViewById(R.id.atB);
        ImageButton foB = view.findViewById(R.id.foB);
        ImageButton stB = view.findViewById(R.id.stB);
        wtB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mapFrame, new MapFragment_wait()).commit();
                view.findViewById(R.id.wtB).setBackgroundResource(R.drawable.cir_border2);
                view.findViewById(R.id.atB).setBackgroundResource(R.drawable.cir_border);
                view.findViewById(R.id.foB).setBackgroundResource(R.drawable.cir_border);
                view.findViewById(R.id.stB).setBackgroundResource(R.drawable.cir_border);
            }
        });
        atB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mapFrame, new MapFragment_information()).commit();
                view.findViewById(R.id.atB).setBackgroundResource(R.drawable.cir_border2);
                view.findViewById(R.id.wtB).setBackgroundResource(R.drawable.cir_border);
                view.findViewById(R.id.foB).setBackgroundResource(R.drawable.cir_border);
                view.findViewById(R.id.stB).setBackgroundResource(R.drawable.cir_border);
            }
        });
        foB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mapFrame, new MapFragment_food()).commit();
                view.findViewById(R.id.foB).setBackgroundResource(R.drawable.cir_border2);
                view.findViewById(R.id.atB).setBackgroundResource(R.drawable.cir_border);
                view.findViewById(R.id.wtB).setBackgroundResource(R.drawable.cir_border);
                view.findViewById(R.id.stB).setBackgroundResource(R.drawable.cir_border);
            }
        });
        stB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.mapFrame, new MapFragment_store()).commit();
                view.findViewById(R.id.stB).setBackgroundResource(R.drawable.cir_border2);
                view.findViewById(R.id.atB).setBackgroundResource(R.drawable.cir_border);
                view.findViewById(R.id.foB).setBackgroundResource(R.drawable.cir_border);
                view.findViewById(R.id.wtB).setBackgroundResource(R.drawable.cir_border);
            }
        });


        return view;
    }


}

