package com.example.ejemplogeolocalicacion

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.Manifest;
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mapa: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        val  mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentmapa) as SupportMapFragment

        mapFragment.getMapAsync(this)


    }
    override fun onMapReady(map: GoogleMap){
        this.mapa = map
        requestLocation()


    }
    private fun requestLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1
            )
            return
        }
        val latitude = intent.getDoubleExtra("latitud", 0.0)
        val longitude = intent.getDoubleExtra("longitud", 0.0)
        val title = intent.getStringExtra("nombre")

        val coordenada = LatLng(latitude, longitude)

        val currentLocation = LatLng(latitude, longitude)
        //mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f))
        mapa.addMarker(MarkerOptions().position(coordenada).title(title))
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {


                }
            }
    }
}