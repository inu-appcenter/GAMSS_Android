package com.inuappcenter.bfcinema


import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.fragment_drawer.*


/**
 * A simple [Fragment] subclass.
 */
class DrawerFragment : Fragment(),View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_drawer, container, false)

        val map = view.findViewById<LinearLayout>(R.id.linear_map)

        map.setOnClickListener(this)
//        linear_pay.setOnClickListener(this)
//        linear_user_info.setOnClickListener(this)

        return view
    }
    override fun onClick(view: View?) {
//        YoYo.with(Techniques.FadeOut)
//            .duration(200)
//            .playOn(view)
        when (view){
            linear_map -> {
                val intentMap = Intent(context,LocationMapActivity::class.java)
                startActivity(intentMap)
                close()
            }
        }
    }
    private fun close() {
        val drawer: DrawerLayout =
            activity!!.findViewById(R.id.drawer_layout)
        drawer.closeDrawer(Gravity.LEFT)
    }
}
