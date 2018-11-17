package ir.kivee.crazyclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val wIntent = Intent(context, AlarmWakeActivity::class.java)
        wIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(wIntent)
    }

}
