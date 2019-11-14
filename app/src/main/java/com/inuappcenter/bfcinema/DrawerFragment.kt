package com.inuappcenter.bfcinema


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_drawer.*

/**
 * A simple [Fragment] subclass.
 */
class DrawerFragment : Fragment(), View.OnClickListener {
    override fun onClick(view: View?) {
        when (view){
//            linear_donation ->
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drawer, container, false)

        linear_donation.setOnClickListener(this)
        linear_map.setOnClickListener(this)
        linear_pay.setOnClickListener(this)
        linear_user_info.setOnClickListener(this)


    }


}
