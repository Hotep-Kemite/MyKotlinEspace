package com.example.films

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DisplayFilm : AppCompatActivity() {
    lateinit var favori: ImageView
    var i = 0
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_film)
        val r = intent.getSerializableExtra("filmItem") as Result?
        favori = findViewById(R.id.DimageFavori)
        val title = findViewById<TextView>(R.id.DtxtTitle)
        title.text = r!!.title
        val des = findViewById<TextView>(R.id.DtxtDescription)
        des.text = r.overview
        val img = findViewById<ImageView>(R.id.Dimage)
        Picasso.get().load(MyAdapter.getImage(r.posterPath)).into(img)
        println(r.title)
        favori.setOnClickListener(View.OnClickListener {
            if (i % 2 == 0) {
                favori.setImageDrawable(getDrawable(R.drawable.hearts_1))
            } else {
                favori.setImageDrawable(getDrawable(R.drawable.hearts))
            }
            i = i + 1
        })
    }
}