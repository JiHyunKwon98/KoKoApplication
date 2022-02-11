package com.example.kokoapplication.find_id

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kokoapplication.R

class FindIdActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id1)
    }

    fun clickId(view: View) {
        var intent = Intent(this, FindIdActivity2::class.java)
        startActivity(intent)
    }
}