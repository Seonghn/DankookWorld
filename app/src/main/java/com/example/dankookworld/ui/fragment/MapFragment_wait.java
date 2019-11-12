package com.example.dankookworld.ui.fragment;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dankookworld.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MapFragment_wait extends Fragment implements OnMapReadyCallback {

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
        LatLng DW = new LatLng(37.322140, 127.126639);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(DW);
        markerOptions.title("단국대학교");
        markerOptions.snippet("범정관");
        mMap.addMarker(markerOptions);

        LatLng l1 = new LatLng(37.322861, 127.129152);
        MarkerOptions m1 = new MarkerOptions();
        m1.position(l1);
        m1.title("매직써클");
        mMap.addMarker(m1);

        LatLng l2 = new LatLng(37.322284, 127.129045);
        MarkerOptions m2 = new MarkerOptions();
        m2.position(l1);
        m2.title("VR스페이스");
        mMap.addMarker(m2);

        LatLng l3 = new LatLng(37.321722, 127.129000);
        MarkerOptions m3 = new MarkerOptions();
        m3.position(l3);
        m3.title("해적선");
        mMap.addMarker(m3);

        LatLng l4 = new LatLng(37.322740, 127.127182);
        MarkerOptions m4 = new MarkerOptions();
        m4.position(l4);
        m4.title("회전목마");
        mMap.addMarker(m4);

        LatLng l5 = new LatLng(37.321159, 127.127468);
        MarkerOptions m5 = new MarkerOptions();
        m5.position(l5);
        m5.title("정글탐험보트");
        mMap.addMarker(m5);

        LatLng l6 = new LatLng(37.320425, 127.128427);
        MarkerOptions m6 = new MarkerOptions();
        m6.position(l6);
        m6.title("모노레일");
        mMap.addMarker(m6);

        LatLng l7 = new LatLng(37.321202, 127.125337);
        MarkerOptions m7 = new MarkerOptions();
        m7.position(l7);
        m7.title("롤러코스터");
        mMap.addMarker(m7);

        LatLng l8 = new LatLng(37.320860, 127.125776);
        MarkerOptions m8 = new MarkerOptions();
        m8.position(l8);
        m8.title("스윙");
        mMap.addMarker(m8);

        LatLng l9 = new LatLng(37.320468, 127.126205);
        MarkerOptions m9 = new MarkerOptions();
        m9.position(l9);
        m9.title("회전바구니");
        mMap.addMarker(m9);

        LatLng l10 = new LatLng(37.320062, 127.126662);
        MarkerOptions m10 = new MarkerOptions();
        m10.position(l10);
        m10.title("후룸라이드");
        mMap.addMarker(m10);

        LatLng l11 = new LatLng(37.319079, 127.127038);
        MarkerOptions m11 = new MarkerOptions();
        m11.position(l11);
        m11.title("회전그네");
        mMap.addMarker(m11);

        LatLng l12 = new LatLng(37.319172, 127.127836);
        MarkerOptions m12 = new MarkerOptions();
        m12.position(l12);
        m12.title("풍선비행");
        mMap.addMarker(m12);

        LatLng l13 = new LatLng(37.319905, 127.125381);
        MarkerOptions m13 = new MarkerOptions();
        m13.position(l13);
        m13.title("스핀");
        mMap.addMarker(m13);

        LatLng l14 = new LatLng(37.320247, 127.125059);
        MarkerOptions m14 = new MarkerOptions();
        m14.position(l14);
        m14.title("유령의집");
        mMap.addMarker(m14);

        LatLng l15 = new LatLng(37.318716, 127.129269);
        MarkerOptions m15 = new MarkerOptions();
        m15.position(l15);
        m15.title("범퍼카");
        mMap.addMarker(m15);

        LatLng l16 = new LatLng(37.319542, 127.129152);
        MarkerOptions m16 = new MarkerOptions();
        m16.position(l16);
        m16.title("어린이전망차");
        mMap.addMarker(m16);

        LatLng l17 = new LatLng(37.320732, 127.129815);
        MarkerOptions m17 = new MarkerOptions();
        m17.position(l17);
        m17.title("거울미로");
        mMap.addMarker(m17);

        LatLng l18 = new LatLng(37.321159, 127.129269);
        MarkerOptions m18 = new MarkerOptions();
        m18.position(l18);
        m18.title("대관람차");
        mMap.addMarker(m18);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DW,17));
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);


//        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener(){
//            @Override
//            public boolean onMyLocationButtonClick() {
//                mMoveMapByAPI = true;
//                return true;
//            }
//        });
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

