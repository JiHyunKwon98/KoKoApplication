package com.example.kokoapplication.find_id

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kokoapplication.R
import com.example.kokoapplication.find_pw.FindPwActivity1
import com.example.kokoapplication.login.LoginActivity

class FindIdActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id2)
    }

    fun clickLogin(view: View) {
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun clickPw(view: View) {
        var intent = Intent(this, FindPwActivity1::class.java)
        startActivity(intent)
    }

}