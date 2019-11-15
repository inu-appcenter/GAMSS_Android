package com.inuappcenter.bfcinema

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.angmarch.views.NiceSpinner
import java.util.*


class MakeReservationActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_reservation)

        val niceSpinner = findViewById<NiceSpinner>(R.id.spinner_people)
        val dataset = LinkedList(listOf("1명", "2명"))
        niceSpinner.attachDataSource<String>(dataset)
    }
}