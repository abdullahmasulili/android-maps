package com.dula.modul1a;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final LatLng TI_UNTAD = new LatLng(-0.8422215,119.8926502);
    private static final LatLng SHARETEA = new LatLng( -0.897158, 119.873913);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (ContextCompat.checkSelfPermission(MapsActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MapsActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(MapsActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }else{
                ActivityCompat.requestPermissions(MapsActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        switch (requestCode){
            case 1: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(MapsActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(TI_UNTAD).title("Marker di Teknik Informatika Untad"));
        mMap.addMarker(new MarkerOptions().position(SHARETEA).title("Marker di Sharetea Gatot Subroto"));
        mMap.setMyLocationEnabled(true);
        // Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(TI_UNTAD)      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(60)                // Sets the orientation of the camera to east
                .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.addPolyline(new PolylineOptions().add(
                TI_UNTAD,
                new LatLng(-0.841829, 119.892744),
                new LatLng(-0.841843, 119.895008),
                new LatLng(-0.843502, 119.894976),
                new LatLng(-0.843466, 119.890962),
                new LatLng(-0.845652, 119.891520),
                new LatLng(-0.846223, 119.891657),
                new LatLng(-0.846851, 119.891759),
                new LatLng(-0.848986, 119.891946),
                new LatLng(-0.851307, 119.892139),
                new LatLng(-0.853568, 119.891970),
                new LatLng(-0.857172, 119.891173),
                new LatLng(-0.858968, 119.890598),
                new LatLng(-0.861491, 119.890053),
                new LatLng(-0.863133, 119.889731),
                new LatLng(-0.864922, 119.889157),
                new LatLng(-0.865688, 119.888806),
                new LatLng(-0.870405, 119.887230),
                new LatLng(-0.870405, 119.887230),
                new LatLng(-0.871017, 119.887249),
                new LatLng(-0.871288, 119.887080),
                new LatLng(-0.871824, 119.887064),
                new LatLng(-0.873859, 119.887144),
                new LatLng(-0.875887, 119.887476),
                new LatLng(-0.877925, 119.887635),
                new LatLng(-0.878426, 119.887638),
                new LatLng(-0.880298, 119.887501),
                new LatLng(-0.885637, 119.886621),
                new LatLng(-0.888144, 119.885428),
                new LatLng(-0.890243, 119.885856),
                new LatLng(-0.890709, 119.885977),
                new LatLng(-0.894641, 119.886851),
                new LatLng(-0.897760, 119.887460),
                new LatLng(-0.897853, 119.887320),
                new LatLng(-0.897221, 119.884943),
                new LatLng(-0.897186, 119.884644),
                new LatLng(-0.897183, 119.882982),
                new LatLng(-0.897141, 119.882066),
                new LatLng(-0.897122, 119.879767),
                new LatLng(-0.897081, 119.877952),
                new LatLng(-0.896867, 119.875260),
                new LatLng(-0.896730, 119.873847),
                new LatLng(-0.897038, 119.873810),
                SHARETEA
        ).color(Color.CYAN));

    }

}
