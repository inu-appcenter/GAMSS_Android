package com.inuappcenter.bfcinema

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_make_reservation.*
import org.angmarch.views.NiceSpinner
import java.util.*


class MakeReservationActivity  : AppCompatActivity(), View.OnClickListener {
    private var item: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_reservation)

        val niceSpinner = findViewById<NiceSpinner>(R.id.spinner_people)
        val dataset = LinkedList(listOf("1명", "2명"))
        niceSpinner.attachDataSource<String>(dataset)
        niceSpinner.setOnSpinnerItemSelectedListener { parent, view, position, id ->
            when(parent.getItemAtPosition(position)){
                "1명" -> item = 1
                "2명" -> item = 2
            }
        }

        btn_back.setOnClickListener(this)
        btn_pay.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_back -> {
                onBackPressed()
            }
            R.id.btn_pay -> {
                val intent = Intent()
                intent.putExtra("num", item)
                setResult(100, intent)
                finish()
            }
        }
    }
}