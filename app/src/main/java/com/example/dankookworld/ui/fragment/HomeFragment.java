package com.example.dankookworld.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dankookworld.QRActivity;
import com.example.dankookworld.R;

public class HomeFragment extends Fragment {

    //    private HomeViewModel homeViewModel;
    private ViewFlipper vf;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        vf = view.findViewById(R.id.vf);
        Button b1 = view.findViewById(R.id.b1);
        Button b2 = view.findViewById(R.id.b2);
        Button explore = view.findViewById(R.id.explore);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.showPrevious();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf.showNext();
            }
        });
        /*explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapFragment.class);
                startActivity(intent);
            }
        });*/


        Button qr_register = view.findViewById(R.id.qr_scan);
        qr_register.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), QRActivity.class);
                startActivity(intent);

            }

        });




        return view;
    }


}
