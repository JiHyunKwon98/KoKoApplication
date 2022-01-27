package com.example.kokoapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kokoapplication.R
import com.example.kokoapplication.find_id.FindIdActivity1
import com.example.kokoapplication.find_pw.FindPwActivity1
import com.example.kokoapplication.sign_up.SignupActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun clickSignUp(view: View) {
        var intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    fun clickFindId(view: View) {
        var intent = Intent(this, FindIdActivity1::class.java)
        startActivity(intent)
    }

    fun clickFindPw(view: View) {
        var intent = Intent(this, FindPwActivity1::class.java)
        startActivity(intent)
    }

}