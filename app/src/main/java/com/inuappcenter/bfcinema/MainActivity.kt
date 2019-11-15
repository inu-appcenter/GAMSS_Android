package com.inuappcenter.bfcinema

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_funding.*
import kotlinx.android.synthetic.main.layout_vote.*

class MainActivity : AppCompatActivity() , View.OnClickListener {
    val VOTE_1 = 1
    val VOTE_2 = 2
    var enabledVote = true

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
        linear_vote1.setOnClickListener(this)
        linear_vote2.setOnClickListener(this)
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
        if (enabledVote){
            when (select){
                VOTE_1 -> {
                    shadow_view_1.visibility = View.INVISIBLE
                    progressBar.setProgress(24,true)
                    tv_percent1.text = "24%"
                    tv_percent2.text = "76%"
                    progressBar.rotation = 180F

                    tv_movie1.setTextColor(Color.parseColor("#3effde"))
                    tv_movie_info1.setTextColor(Color.parseColor("#3effde"))
                }
                VOTE_2 -> {
                    shadow_view_2.visibility = View.INVISIBLE
                    progressBar.setProgress(82,true)
                    tv_percent1.text = "18%"
                    tv_percent2.text = "82%"

                    tv_movie2.setTextColor(Color.parseColor("#3effde"))
                    tv_movie_info2.setTextColor(Color.parseColor("#3effde"))
                }
            }
            progressBar.visibility = View.VISIBLE
            tv_percent1.visibility = View.VISIBLE
            tv_percent2.visibility = View.VISIBLE
            enabledVote = false
        }else{
            Toast.makeText(this,"투표는 한 번만 가능합니다",Toast.LENGTH_SHORT).show()
        }
    }

}
