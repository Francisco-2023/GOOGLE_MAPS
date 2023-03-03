package com.example.googlemaps_marcadoresconinterfaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
    GoogleMap Mapas;

    public TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        Mapas=googleMap;
        Mapas.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        LatLng ltBF= new LatLng(-0.8869472219457313, -79.48753013607134);


        //Activar los controles del Zoom
        Mapas.getUiSettings().setZoomControlsEnabled(true);


        CameraUpdate camUpdBF= CameraUpdateFactory.newLatLngZoom(ltBF,15);
        Mapas.moveCamera(camUpdBF);

        LatLng HOME = new LatLng(-0.8881818459346897, -79.48535048443613);
        Mapas.addMarker(new MarkerOptions().position(HOME).title("FAMILIA ZAMBRANO VARELA").snippet(String.valueOf("Coop.Nueva BuenaFe"+
                "                          Lotización el Cortijo"+
                "                         -0.888210846947175, -79.48533408726612" +
                "                          PROPIEDAD PRIVADA"
        )).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_home)).anchor(0.1f,0.1f));

        Mapas.setInfoWindowAdapter(new MyInfoWindowAdapter(this));
        }
    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

}




