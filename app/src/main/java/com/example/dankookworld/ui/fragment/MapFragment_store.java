package com.example.dankookworld.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dankookworld.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment_store extends Fragment implements OnMapReadyCallback {

    GoogleMap mMap;
    private MapView mapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_wait, container, false);
        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng DW = new LatLng(37.322643, 127.125072);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(DW);
        markerOptions.title("단국대학교");
        markerOptions.snippet("범정관");

        LatLng l1 = new LatLng(37.323047, 127.126698);
        MarkerOptions m1 = new MarkerOptions();
        m1.position(l1);
        m1.title("감독의 분장실/의상실");
        mMap.addMarker(m1);

        LatLng l2 = new LatLng(37.322933, 127.125220);
        MarkerOptions m2 = new MarkerOptions();
        m2.position(l1);
        m2.title("아일랜드 기프트샵");
        mMap.addMarker(m2);

        LatLng l3 = new LatLng(37.322341, 127.123742);
        MarkerOptions m3 = new MarkerOptions();
        m3.position(l3);
        m3.title("환타지 기프트샵");
        mMap.addMarker(m3);

        LatLng l4 = new LatLng(37.323303, 127.123993);
        MarkerOptions m4 = new MarkerOptions();
        m4.position(l4);
        m4.title("캐슬카트");
        mMap.addMarker(m4);

        LatLng l5 = new LatLng(37.323716, 127.125095);
        MarkerOptions m5 = new MarkerOptions();
        m5.position(l5);
        m5.title("토이플러스");
        mMap.addMarker(m5);

        LatLng l6 = new LatLng(37.321330, 127.124978);
        MarkerOptions m6 = new MarkerOptions();
        m6.position(l6);
        m6.title("헬로키티");
        mMap.addMarker(m6);

        LatLng l7 = new LatLng(37.322341, 127.126895);
        MarkerOptions m7 = new MarkerOptions();
        m7.position(l7);
        m7.title("킹덤플라자");
        mMap.addMarker(m7);

        LatLng l8 = new LatLng(37.321593, 127.127836);
        MarkerOptions m8 = new MarkerOptions();
        m8.position(l8);
        m8.title("케이스갤러리");
        mMap.addMarker(m8);

        LatLng l9 = new LatLng(37.321850, 127.126080);
        MarkerOptions m9 = new MarkerOptions();
        m9.position(l9);
        m9.title("스타샵");
        mMap.addMarker(m9);

        LatLng l10 = new LatLng(37.321480, 127.123895);
        MarkerOptions m10 = new MarkerOptions();
        m10.position(l10);
        m10.title("미야비드레스");
        mMap.addMarker(m10);


        mMap.addMarker(markerOptions);
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

