package ir.kivee.crazyclock

import android.app.Activity
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_add_alarm.*
import java.util.*


class AddAlarmActivity : AppCompatActivity() {

    val RINGTONE_REQUEST_CODE = 5
    var currentUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_alarm)
        handleWheel()
        getNow()
        enableVibration()
        add_alarm_ringtone.setOnClickListener {
            val intent = Intent(RingtoneManager.ACTION_RINGTONE_PICKER)
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_ALARM)
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Ringtone")
            intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, currentUri)
            this.startActivityForResult(intent, RINGTONE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RINGTONE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val uri = data?.getParcelableExtra<Uri>(RingtoneManager.EXTRA_RINGTONE_PICKED_URI)
            if (uri != null) {
                Log.d("p4yam", "Uri is: $uri")
                currentUri = uri
                val ringtone = RingtoneManager.getRingtone(this, uri)
                add_alarm_ringtone_name.text = ringtone.getTitle(this)
            }

        }

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




