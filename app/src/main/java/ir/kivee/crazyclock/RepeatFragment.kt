package ir.kivee.crazyclock

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.widget.Toast

class RepeatFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Repeat")
                    .setItems(arrayOf("Only Ring nce", "Everyday")
                    ) { _, which ->
                        Toast.makeText(it, which.toString(), Toast.LENGTH_SHORT).show()
                    }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}