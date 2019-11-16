package com.inuappcenter.bfcinema

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.fragment_movie.iv_poster
import kotlinx.android.synthetic.main.fragment_movie.tv_name
import kotlinx.android.synthetic.main.layout_movie_detail.*

class MovieDetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onResume() {
        super.onResume()

        YoYo.with(Techniques.FadeInUp).duration(1000).playOn(iv_poster)
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(tv_name)
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(tv_genre)
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(tv_year)
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(tv_date)
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(tv_location)
        YoYo.with(Techniques.Pulse).duration(1400).playOn(tv_remaining)
        YoYo.with(Techniques.FadeInUp).duration(1400).playOn(tv_status)
        YoYo.with(Techniques.FadeInLeft).duration(1400).playOn(iv_progress)

        YoYo.with(Techniques.FadeInDown).duration(1000).playOn(tv_story)
        YoYo.with(Techniques.FadeIn).duration(1000).playOn(ll_info)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieName = intent.getStringExtra("movie")
        choiceMovie(movieName)

        btn_back.setOnClickListener(this)
        btn_reservation.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_back -> {
                onBackPressed()
            }
//            R.id.btn_bookmark -> {
//            }
            R.id.btn_reservation -> {
                val intent = Intent(this, MakeReservationActivity::class.java)
                startActivityForResult(intent, 100)
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        if (requestCode == 100) {
            if (resultCode == 100) {
                val num = intent!!.getIntExtra("num", 1)
                val text = tv_remaining.text[0].toString().toInt()
                tv_remaining.text = (text - num).toString() + "석 남음"
            }
        }
    }

    private fun choiceMovie(movieName:String) {
        val array: Array<String>
        when (movieName) {
            "movie1" -> {
                iv_poster.setImageResource(R.drawable.this_week_movie1)
                array = resources.getStringArray(R.array.movie1)
                tv_name.text = array.get(0)
                tv_genre.text = array.get(2)
                tv_year.text = array.get(3)
                tv_date.text = array.get(4)
                tv_location.text = array.get(5)
                tv_remaining.text = array.get(6)
                tv_status.text = array.get(7)
                tv_story.text = array.get(8)
                tv_seats.text = array.get(9)
                tv_runningtime.text = array.get(10)
            }
            "movie2" -> {
                iv_poster.setImageResource(R.drawable.this_week_movie2)
                array = resources.getStringArray(R.array.movie2)
                tv_name.text = array.get(0)
                tv_genre.text = array.get(2)
                tv_year.text = array.get(3)
                tv_date.text = array.get(4)
                tv_location.text = array.get(5)
                tv_remaining.text = array.get(6)
                tv_status.text = array.get(7)
                tv_story.text = array.get(8)
                tv_seats.text = array.get(9)
                tv_runningtime.text = array.get(10)
            }
            else -> Toast.makeText(this, "영화를 다시 선택해주세요", Toast.LENGTH_SHORT).show()
        }
    }
}