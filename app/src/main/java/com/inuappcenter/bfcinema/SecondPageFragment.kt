package com.inuappcenter.bfcinema

import android.content.Intent
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
        val imageView = view.findViewById<ImageView>(R.id.iv_poster)
        imageView.setImageResource(R.drawable.this_week_movie2)
        val array: Array<String> = resources.getStringArray(R.array.movie2)
        view.findViewById<TextView>(R.id.tv_name).text = array.get(0)
        view.findViewById<RatingBar>(R.id.rb).rating = array.get(1).toFloat()
        view.findViewById<TextView>(R.id.tv_genre).text = array.get(2)
        view.findViewById<TextView>(R.id.tv_year).text = array.get(3)

        imageView.setOnClickListener{
            val intent = Intent(activity, MovieDetailActivity::class.java)
            intent.putExtra("movie", "movie2")
            activity?.overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
            startActivity(intent)
        }
        return view
    }
}