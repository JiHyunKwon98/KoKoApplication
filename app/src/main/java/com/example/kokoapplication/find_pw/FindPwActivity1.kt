package com.example.kokoapplication.find_pw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kokoapplication.R

class FindPwActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw1)
    }

    fun clickPw1(view: View) {
        var intent = Intent(this, FindPwActivity2::class.java)
        startActivity(intent)
    }
}