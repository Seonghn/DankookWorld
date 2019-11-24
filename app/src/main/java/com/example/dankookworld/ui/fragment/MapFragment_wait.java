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

public class MapFragment_wait extends Fragment implements OnMapReadyCallback {

    GoogleMap mMap;
    private MapView mapView;
    private Context context;
    private ImageView atImage;
    private TextView atText;
    private String pid = "dd";
    private View view;
    private LinearLayout linearLayout;
    private Button pageButton;
    private int height = 480;
    private String mNumber;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private TextView setT;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.map_wait, container, false);
        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        context = container.getContext();
        mapView.getMapAsync(this);

        pageButton = view.findViewById(R.id.pageButton);
        pageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(getActivity(), PageActivity.class);
                intent.putExtra("mfN","wait");
                intent.putExtra("id", pid);
                intent.putExtra("mNumber", mNumber);
                startActivity(intent);
            }
        });
        return view;
    }

//    @Override
//    public void startActivityForResult(Intent intent, int requestCode) {
//        super.startActivityForResult(intent, requestCode);
//    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng DW = new LatLng(37.321256, 127.127451);
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(DW);
//        markerOptions.title("단국대학교");
//        markerOptions.snippet("범정관");
//        mMap.addMarker(markerOptions);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
//                atImage = view.findViewById(R.id.foodView);
//                atText = view.findViewById(R.id.foodName);
//                atText.setText(pid);
//                atImage.setImageResource(R.drawable.bul);
                linearLayout = view.findViewById(R.id.mapRelative);
                LinearLayout.LayoutParams r_p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                linearLayout.setLayoutParams(r_p);
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                pid = marker.getTitle();
                mNumber = marker.getId();
                String[] d = mNumber.split("m");
                String viewID = "wait" + d[1];
                int resID = getResources().getIdentifier(viewID,"drawable", getActivity().getPackageName());
                atImage = view.findViewById(R.id.waitView);
                atText = view.findViewById(R.id.waitName);

                atText.setText(pid);
                atImage.setImageResource(resID);

                linearLayout = view.findViewById(R.id.mapRelative);

                LinearLayout.LayoutParams r_p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height);
                linearLayout.setLayoutParams(r_p);

                setT = view.findViewById(R.id.setT);
                if(pid != "dd") {
                    DocumentReference docRef = firebaseFirestore.collection("놀이기구").document(pid);
                    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document != null) {
                                    setT.setText("대기시간 : " + document.getString("대기시간"));
                            }
                            }
                        }
                    });
                }
                return false;
            }
        });
//        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//            @Override
//            public void onInfoWindowClick(Marker marker) {
//                Intent intent = new Intent(getActivity(), PageActivity.class);
//                startActivity(intent);
//            }
//        });

        LatLng l1 = new LatLng(37.322861, 127.129152);
        MarkerOptions m1 = new MarkerOptions();
        m1.position(l1);
        m1.title("매직써클");
        mMap.addMarker(m1);

        LatLng l2 = new LatLng(37.322284, 127.129045);
        MarkerOptions m2 = new MarkerOptions();
        m2.position(l2);
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

