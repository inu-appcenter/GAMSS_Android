package com.inuappcenter.bfcinema

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            LayoutParams.FLAG_FULLSCREEN,
            LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intentSplash = Intent(this, LoginActivity::class.java)
            this.startActivity(intentSplash)
            overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
            this.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}
