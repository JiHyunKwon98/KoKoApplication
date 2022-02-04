package com.example.kokoapplication.find_pw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kokoapplication.R

class FindPwActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_pw2)
    }

    fun clickPw2(view: View) {
        var intent = Intent(this, FindPwActivity3::class.java)
        startActivity(intent)
    }
}