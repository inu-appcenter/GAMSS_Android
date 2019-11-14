package com.inuappcenter.bfcinema

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_funding.*
import kotlinx.android.synthetic.main.layout_vote.*

class MainActivity : AppCompatActivity() , View.OnClickListener {
    val VOTE_1 = 1
    val VOTE_2 = 2

    override fun onClick(v: View?) {
        when (v){
            btn_drawer -> drawer_layout.openDrawer(Gravity.LEFT)
            linear_vote1 -> setProgressVote(VOTE_1)
            linear_vote2 -> setProgressVote(VOTE_2)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MoviePagerAdapter(supportFragmentManager)
        vp_movie.adapter = adapter

        btn_drawer.setOnClickListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(findViewById<View>(R.id.drawer_main))) {
            drawer_layout.closeDrawers()
        }
        else {
            super.onBackPressed()
        }
    }
    fun setProgressVote(select:Int){

    }

}
