package com.example.kokoapplication.find_pw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kokoapplication.R

class FindPwActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw3)
    }

    fun clickPw3(view: View) {
        var intent = Intent(this, FindPwActivity4::class.java)
        startActivity(intent)
    }
}