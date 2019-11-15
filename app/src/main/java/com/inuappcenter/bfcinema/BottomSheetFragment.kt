package com.inuappcenter.bfcinema


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)

        val tvName = view.findViewById<TextView>(R.id.tv_location_name)
        val tvContent = view.findViewById<TextView>(R.id.tv_location_content)
        val tvTel = view.findViewById<TextView>(R.id.tv_location_tel)
        val array: Array<String>
        when(tag){
            "guwal"-> {
                array = resources.getStringArray(R.array.guwal)
                tvName.text = array.get(0)
                tvContent.text = array.get(1)
                tvTel.text = array.get(2)
            }
            "chunghak"->{
                array = resources.getStringArray(R.array.chunghak)
                tvName.text = array.get(0)
                tvContent.text = array.get(1)
                tvTel.text = array.get(2)
            }
            "seogu"->{
                array = resources.getStringArray(R.array.seogu)
                tvName.text = array.get(0)
                tvContent.text = array.get(1)
                tvTel.text = array.get(2)
            }
        }
        return view
    }
}
