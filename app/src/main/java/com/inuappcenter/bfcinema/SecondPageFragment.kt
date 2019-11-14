package com.inuappcenter.bfcinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondPageFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        view.findViewById<ImageView>(R.id.iv_poster).setImageResource(R.drawable.this_week_movie2)
        view.findViewById<TextView>(R.id.tv_name).text = "개를 훔치는 완벽한 방법"
        view.findViewById<RatingBar>(R.id.rb).rating = 3.7F
        view.findViewById<TextView>(R.id.tv_genre).text = "드라마"
        view.findViewById<TextView>(R.id.tv_year).text = "2014"

        return view
    }
}