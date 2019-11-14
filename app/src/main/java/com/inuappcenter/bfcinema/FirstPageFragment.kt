package com.inuappcenter.bfcinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment

class FirstPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        view.findViewById<ImageView>(R.id.iv_poster).setImageResource(R.drawable.this_week_movie1)
        val array: Array<String> = resources.getStringArray(R.array.movie1)
        view.findViewById<TextView>(R.id.tv_name).text = array.get(0)
        view.findViewById<RatingBar>(R.id.rb).rating = array.get(1).toFloat()
        view.findViewById<TextView>(R.id.tv_genre).text = array.get(2)
        view.findViewById<TextView>(R.id.tv_year).text = array.get(3)

        return view
    }
}