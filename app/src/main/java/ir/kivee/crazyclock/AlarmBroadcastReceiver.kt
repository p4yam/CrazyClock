package ir.kivee.crazyclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("p4yam", "Done!")
        val wIntent = Intent(context, AlarmWakeActivity::class.java)
        wIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context?.startActivity(wIntent)
    }

}
