package ir.kivee.crazyclock

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_add_alarm_img.setOnClickListener { createAlarm() }
/*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            with(window) {
                requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

            }*/
    }

    private fun createAlarm() {
        val intent = Intent(this, AddAlarmActivity::class.java)
        val options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this,main_header,"header")
        startActivity(intent,options.toBundle())
    }
}

