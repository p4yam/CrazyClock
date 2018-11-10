package ir.kivee.crazyclock

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_alarm.*
import java.util.*

class AddAlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_alarm)
        handleWheel()
        getNow()
        enableVibration()
    }

    private fun handleWheel() {
        val hours = ArrayList<Int>()
        val minutes = ArrayList<String>()
        for (i in 1..12)
            hours.add(i)
        add_places_wheel_hour.data = hours
        for (i in 0..59)
            if (i < 10)
                minutes.add("0" + i.toString())
            else
                minutes.add(i.toString())
        add_places_wheel_minutes.data = minutes
        val type = ArrayList<String>()
        type.add("AM")
        type.add("PM")
        add_places_wheel_ampm.data = type
    }

    private fun getNow() {
        val currentTime = Calendar.getInstance()
        add_places_wheel_hour.selectedItemPosition = currentTime.get(Calendar.HOUR) - 1
        add_places_wheel_ampm.selectedItemPosition = currentTime.get(Calendar.AM_PM)
        add_places_wheel_minutes.selectedItemPosition = currentTime.get(Calendar.MINUTE) - 1

    }

    private fun enableVibration() {
        add_alarm_vibration.setOnClickListener {
            add_alarm_switch.isChecked = !add_alarm_switch.isChecked
        }

    }

}




