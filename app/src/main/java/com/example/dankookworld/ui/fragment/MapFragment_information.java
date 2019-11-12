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

public class MapFragment_information extends Fragment implements OnMapReadyCallback {

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
        LatLng DW = new LatLng(37.321496, 127.126718);
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(DW);
//        markerOptions.title("단국대학교");
//        markerOptions.snippet("범정관");

        LatLng l1 = new LatLng(37.322655, 127.126027);
        MarkerOptions m1 = new MarkerOptions();
        m1.position(l1);
        m1.title("정문 인포메이션");
        mMap.addMarker(m1);

        LatLng l2 = new LatLng(37.321276, 127.127455);
        MarkerOptions m2 = new MarkerOptions();
        m2.position(l1);
        m2.title("중앙 인포메이션");
        mMap.addMarker(m2);

        LatLng l3 = new LatLng(37.319953, 127.125588);
        MarkerOptions m3 = new MarkerOptions();
        m3.position(l3);
        m3.title("인포메이션 동");
        mMap.addMarker(m3);

        LatLng l4 = new LatLng(37.322308, 127.128989);
        MarkerOptions m4 = new MarkerOptions();
        m4.position(l4);
        m4.title("인포메이션 서");
        mMap.addMarker(m4);

        LatLng l5 = new LatLng(37.321856, 127.124869);
        MarkerOptions m5 = new MarkerOptions();
        m5.position(l5);
        m5.title("화장실1");
        mMap.addMarker(m5);

        LatLng l6 = new LatLng(37.322744, 127.127369);
        MarkerOptions m6 = new MarkerOptions();
        m6.position(l6);
        m6.title("화장실2");
        mMap.addMarker(m6);

        LatLng l7 = new LatLng(37.320482, 127.126232);
        MarkerOptions m7 = new MarkerOptions();
        m7.position(l7);
        m7.title("화장실3");
        mMap.addMarker(m7);

        LatLng l8 = new LatLng(37.321737, 127.129064);
        MarkerOptions m8 = new MarkerOptions();
        m8.position(l8);
        m8.title("화장실4");
        mMap.addMarker(m8);

        LatLng l9 = new LatLng(37.320354, 127.128474);
        MarkerOptions m9 = new MarkerOptions();
        m9.position(l9);
        m9.title("물품보관함1");
        mMap.addMarker(m9);

        LatLng l10 = new LatLng(37.321208, 127.125373);
        MarkerOptions m10 = new MarkerOptions();
        m10.position(l10);
        m10.title("물품보관함2");
        mMap.addMarker(m10);

        LatLng l11 = new LatLng(37.321909, 127.126950);
        MarkerOptions m11 = new MarkerOptions();
        m11.position(l11);
        m11.title("미아보호소");
        mMap.addMarker(m11);

        LatLng l12 = new LatLng(37.321505, 127.123702);
        MarkerOptions m12 = new MarkerOptions();
        m12.position(l12);
        m12.title("서매표소");
        mMap.addMarker(m12);

        LatLng l13 = new LatLng(37.320812, 127.125808);
        MarkerOptions m13 = new MarkerOptions();
        m13.position(l13);
        m13.title("동매표소");
        mMap.addMarker(m13);

//        mMap.addMarker(markerOptions);
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

