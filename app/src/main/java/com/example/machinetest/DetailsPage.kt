package com.example.machinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso

class DetailsPage : AppCompatActivity() {
    lateinit var imageview: AppCompatImageView
    lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)

        val back = findViewById(R.id.back) as ImageView?
        back?.setOnClickListener {
            // your code to perform when the user clicks on the ImageView
            onBackPressed()
        }
        tv = findViewById(R.id.name)
        imageview = findViewById(R.id.imageview)
        val titel = intent.getStringExtra("title")
        val thumbnailUrl = intent.getStringExtra("thumbnailUrl")

        tv.text = titel
        Picasso.with(applicationContext).load(thumbnailUrl).into(imageview)

    }


}