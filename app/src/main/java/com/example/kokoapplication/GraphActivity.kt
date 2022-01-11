package com.example.kokoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class GraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        val gograp : ImageView = findViewById(R.id.gograp)
        val golist : ImageView = findViewById(R.id.golist)
        val gohome : ImageView = findViewById(R.id.gohome)
        val gomy : ImageView = findViewById(R.id.gomy)

        gograp.setOnClickListener{
            val intent = Intent(this@GraphActivity, GraphActivity::class.java)
            startActivity(intent)
        }

        golist.setOnClickListener{
            val intent = Intent(this@GraphActivity, ManageActivity::class.java)
            startActivity(intent)
        }

        gohome.setOnClickListener{
            val intent = Intent(this@GraphActivity, DatePickerActivity::class.java)
            startActivity(intent)
        }


        gomy.setOnClickListener{
            val intent = Intent(this@GraphActivity, MyActivity::class.java)
            startActivity(intent)
        }
    }
}