package com.example.kokoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        val gograp : ImageView = findViewById(R.id.gograp)
        val golist : ImageView = findViewById(R.id.golist)
        val gohome : ImageView = findViewById(R.id.gohome)
        val gomy : ImageView = findViewById(R.id.gomy)

        gograp.setOnClickListener{
            val intent = Intent(this@MyActivity, GraphActivity::class.java)
            startActivity(intent)
        }

        golist.setOnClickListener{
            val intent = Intent(this@MyActivity, ManageActivity::class.java)
            startActivity(intent)
        }

        gohome.setOnClickListener{
            val intent = Intent(this@MyActivity, DatePickerActivity::class.java)
            startActivity(intent)
        }


        gomy.setOnClickListener{
            val intent = Intent(this@MyActivity, MyActivity::class.java)
            startActivity(intent)
        }
    }
}