package com.inuappcenter.bfcinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_drawer.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    override fun onClick(v: View?) {
        when (v){
            btn_drawer -> drawer_layout.openDrawer(Gravity.LEFT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_drawer.setOnClickListener(this)
        var drawer = getSupportFragmentManager().findFragmentById(R.id.drawer)

    }
}
