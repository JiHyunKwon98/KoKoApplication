package com.example.kokoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ManageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)

        val gograp : ImageView = findViewById(R.id.gograp)
        val golist : ImageView = findViewById(R.id.golist)
        val gohome : ImageView = findViewById(R.id.gohome)
        val gomy : ImageView = findViewById(R.id.gomy)

        gograp.setOnClickListener{
            val intent = Intent(this@ManageActivity, GraphActivity::class.java)
            startActivity(intent)
        }

        golist.setOnClickListener{
            val intent = Intent(this@ManageActivity, ManageActivity::class.java)
            startActivity(intent)
        }

        gohome.setOnClickListener{
            val intent = Intent(this@ManageActivity, DatePickerActivity::class.java)
            startActivity(intent)
        }


        gomy.setOnClickListener{
            val intent = Intent(this@ManageActivity, MyActivity::class.java)
            startActivity(intent)
        }

    }
}