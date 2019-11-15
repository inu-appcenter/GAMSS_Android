package com.inuappcenter.bfcinema

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class LocationMapActivity : FragmentActivity() , OnMapReadyCallback {
    lateinit var mMap : GoogleMap

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        val seoul =
            LatLng(37.52487, 126.92723)

        // 구글 맵에 표시할 마커에 대한 옵션 설정
        val makerOptions =
            MarkerOptions()
        makerOptions
            .position(seoul)
            .title("원하는 위치(위도, 경도)에 마커를 표시했습니다.")

        // 마커를 생성한다.
        mMap.addMarker(makerOptions)

        //카메라를 여의도 위치로 옮긴다.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }
}
