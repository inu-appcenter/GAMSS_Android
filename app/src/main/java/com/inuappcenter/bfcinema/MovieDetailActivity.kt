package com.inuappcenter.bfcinema

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.fragment_movie.iv_poster
import kotlinx.android.synthetic.main.fragment_movie.tv_name
import kotlinx.android.synthetic.main.layout_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieName = intent.getStringExtra("movie")
        val array: Array<String>
        if (movieName.equals("movie1") ) {
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
        } else if (movieName.equals("movie2")) {
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
        } else {
            Toast.makeText(this, "영화를 다시 선택해주세요", Toast.LENGTH_SHORT).show()
        }
    }
}