package com.example.kokoapplication

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker

class SleepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep)

        hideTimeHeaderLayout(findViewById(R.id.sleep_timePicker))
    }

    private fun hideTimeHeaderLayout(picker: TimePicker) {
        val id = Resources.getSystem().getIdentifier("time_header", "id", "android")
        val timeLayout = picker.findViewById<View>(id)
        if (timeLayout != null) {
            timeLayout.visibility = View.GONE
        }
    }
}