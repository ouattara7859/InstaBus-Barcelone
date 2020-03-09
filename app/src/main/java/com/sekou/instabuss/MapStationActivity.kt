package com.example.instabus

import Json4Kotlin_Base
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import com.sekou.instabuss.R

class MapStationActivity : Fragment (), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    companion object {
        var mapFragment : SupportMapFragment?=null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_map_station, container, false)

        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        return rootView
    }

    private fun getJson(): String? {
        val jsonString: String = getResources().openRawResource(R.raw.get_bus_station_request).bufferedReader().use { it.readText() }
        return jsonString
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!

        val json = getJson()
        val topic = Gson().fromJson(json, Json4Kotlin_Base::class.java)

        topic.data.nearstations.forEach {
            val location1 = LatLng(it.lat,it.lon)
            mMap.addMarker(MarkerOptions().position(location1).title(it.street_name))

            val cameraUpdate =
                CameraUpdateFactory.newLatLngZoom(location1, 13f)
            //Animate the zoom using the animateCamera() method
            //Animate the zoom using the animateCamera() method
            googleMap.animateCamera(cameraUpdate)
        }
    }
}