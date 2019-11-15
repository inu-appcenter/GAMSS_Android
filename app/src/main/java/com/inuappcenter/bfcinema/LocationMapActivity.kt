package com.inuappcenter.bfcinema

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class LocationMapActivity : FragmentActivity() , OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    override fun onMarkerClick(p0: Marker?): Boolean {
        showBottomSheet()
        return true
    }

    lateinit var mMap : GoogleMap

    override fun onMapReady(googleMap: GoogleMap?) {
        val bitmapDraw =
            resources.getDrawable(R.drawable.map_marker) as BitmapDrawable
        val b: Bitmap? = bitmapDraw.bitmap

        mMap = googleMap!!
        val chunghak = LatLng(37.425434, 126.66528)
        val seogu = LatLng(37.490819, 126.671800)
        val guwal = LatLng(37.462026, 126.725160)
        val center = LatLng(37.460473, 126.691348)

        val locationArray : ArrayList<LatLng> = java.util.ArrayList()
        locationArray.add(chunghak)
        locationArray.add(guwal)
        locationArray.add(seogu)

        for (i in 0 until locationArray.size){
            val markerOptions = MarkerOptions()
            markerOptions.position(locationArray.get(i))
//                .title("청학동 베프시네마")
            val smallMarker: Bitmap? =
                Bitmap.createScaledBitmap(b!!, dpToPx(baseContext,66), dpToPx(baseContext,83), false)
            markerOptions.icon(
                BitmapDescriptorFactory.fromBitmap(
                    smallMarker
                )
            )
            // 마커를 생성한다.
            mMap.addMarker(markerOptions)
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center,12f))
        mMap.setOnMarkerClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }
    fun showBottomSheet(){
        val bottomSheetFragment=BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager,"bottomSheet")
    }

    // dp -> pixel 단위로 변경
    private fun dpToPx(context: Context, dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}
