package com.example.dankookworld.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dankookworld.PageActivity;
import com.example.dankookworld.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MapFragment_food extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    GoogleMap mMap;
    private MapView mapView;
    private Context context;
    private ImageView atImage;
    private TextView atText;
    private String pid = "dd";
    private View view;
    private Integer height = 1700;
    private LinearLayout linearLayout;
    private String mNumber;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private TextView setT;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.map_food, container, false);
        mapView = (MapView) view.findViewById(R.id.map3);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);
        context = container.getContext();
        Button pageButton = view.findViewById(R.id.pageButton3);
        pageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PageActivity.class);
                intent.putExtra("mfN","food");
                intent.putExtra("id", pid);
                intent.putExtra("mNumber", mNumber);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng DW = new LatLng(37.322643, 127.125072);


        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
//                atImage = view.findViewById(R.id.foodView);
//                atText = view.findViewById(R.id.foodName);
//                atText.setText(pid);
//                atImage.setImageResource(R.drawable.bul);
                linearLayout = view.findViewById(R.id.mapRelative3);
                LinearLayout.LayoutParams r_p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                linearLayout.setLayoutParams(r_p);
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mNumber = marker.getId();
                pid = marker.getTitle();
                String[] d = mNumber.split("m");
                String viewID = "food" + d[1];
                int resID = getResources().getIdentifier(viewID,"drawable", getActivity().getPackageName());
                atImage = view.findViewById(R.id.foodView);
                atText = view.findViewById(R.id.foodName);

                atText.setText(pid);
                atImage.setImageResource(resID);

                linearLayout = view.findViewById(R.id.mapRelative3);
                LinearLayout.LayoutParams r_p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height);
                linearLayout.setLayoutParams(r_p);

                setT = view.findViewById(R.id.setT3);
                if(pid != "dd") {
                    DocumentReference docRef = firebaseFirestore.collection("음식점").document(pid);
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document != null) {
                                    setT.setText(document.getString("대표메뉴"));
                                }
                            }
                        }
                    });
                }

                return false;
            }
        });

        LatLng l1 = new LatLng(37.323523, 127.124110);
        MarkerOptions m1 = new MarkerOptions();
        m1.position(l1);
        m1.title("함지박");
        mMap.addMarker(m1);

//        LatLng l2 = new LatLng(37.323523, 127.124110);
//        MarkerOptions m2 = new MarkerOptions();
//        m2.position(l2);
//        m2.title("단국대학교");
//        m2.snippet("범정관");
//        mMap.addMarker(m2);

        LatLng l2 = new LatLng(37.322833, 127.124741);
        MarkerOptions m2 = new MarkerOptions();
        m2.position(l2);
        m2.title("니뽕내뽕");
//        mMap.addMarker(m2);
        onMarkerClick(mMap.addMarker(m2));
//        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                getFragmentManager().beginTransaction().add(R.id.markerFrame, new MarkerFragment()).commit();
//                return false;
//            }
//        });

        LatLng l3 = new LatLng(37.322650, 127.124248);
        MarkerOptions m3 = new MarkerOptions();
        m3.position(l3);
        m3.title("McDonalds");
        mMap.addMarker(m3);

        LatLng l4 = new LatLng(37.323023, 127.124012);
        MarkerOptions m4 = new MarkerOptions();
        m4.position(l4);
        m4.title("베트남노상식당");
        mMap.addMarker(m4);

        LatLng l5 = new LatLng(37.320993, 127.124650);
        MarkerOptions m5 = new MarkerOptions();
        m5.position(l5);
        m5.title("GS25");
        mMap.addMarker(m5);

        LatLng l6 = new LatLng(37.321877, 127.124850);
        MarkerOptions m6 = new MarkerOptions();
        m6.position(l6);
        m6.title("두끼");
        mMap.addMarker(m6);

        LatLng l7 = new LatLng(37.323005, 127.123614);
        MarkerOptions m7 = new MarkerOptions();
        m7.position(l7);
        m7.title("낙원스낵");
        mMap.addMarker(m7);

        LatLng l8 = new LatLng(37.323465, 127.124747);
        MarkerOptions m8 = new MarkerOptions();
        m8.position(l8);
        m8.title("청년다방");
        mMap.addMarker(m8);

        LatLng l9 = new LatLng(37.322740, 127.127211);
        MarkerOptions m9 = new MarkerOptions();
        m9.position(l9);
        m9.title("오레오츄러스카페");
        mMap.addMarker(m9);

        LatLng l10 = new LatLng(37.324252, 127.125761);
        MarkerOptions m10 = new MarkerOptions();
        m10.position(l10);
        m10.title("투썸플레이스");
        mMap.addMarker(m10);

        LatLng l11 = new LatLng(37.324000, 127.125096);
        MarkerOptions m11 = new MarkerOptions();
        m11.position(l11);
        m11.title("아쿠아플라자");
        mMap.addMarker(m11);

        LatLng l12 = new LatLng(37.321505, 127.123702);
        MarkerOptions m12 = new MarkerOptions();
        m12.position(l12);
        m12.title("스무디킹");
        mMap.addMarker(m12);

        LatLng l13 = new LatLng(37.320875, 127.125825);
        MarkerOptions m13 = new MarkerOptions();
        m13.position(l13);
        m13.title("퀴즈노스");
        mMap.addMarker(m13);

        LatLng l14 = new LatLng(37.321927, 127.126680);
        MarkerOptions m14 = new MarkerOptions();
        m14.position(l14);
        m14.title("뉴욕핫도그");
        mMap.addMarker(m14);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DW,17));
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
//        getFragmentManager().beginTransaction().add(R.id.markerFrame, new MarkerFragment()).commit();
        return false;
    }


//    GoogleMap.OnMarkerClickListener markerClickListener = new GoogleMap.OnMarkerClickListener() {
//        @Override
//        public boolean onMarkerClick(Marker marker) {
//
//            getFragmentManager().beginTransaction().add(R.id.mapFrame, new MarkerFragment()).commit();
//
//            return false;
//        }
//    };

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        mapView.onSaveInstanceState(outState);
//    }
////
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        //액티비티가 처음 생성될 때 실행되는 함수
//
//        if (mapView != null) {
//            mapView.onCreate(savedInstanceState);
//        }
//    }

}

