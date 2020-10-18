package com.example.films

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso

class MyAdapter(context: Context?, list: ListFilms?) : BaseAdapter() {

    var list: ListFilms? = null

    override fun getCount(): Int {
        return list!!.results!!.size
    }

    override fun getItem(position: Int): Result {
        return list!!.results!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout: ConstraintLayout
        layout = if (convertView == null) {
            LayoutInflater.from(parent.context)!!.inflate(R.layout.film_layout, parent, false) as ConstraintLayout
        } else {
            convertView as ConstraintLayout
        }
        val title = layout.findViewById<TextView>(R.id.txtTitle)
        val vote = layout.findViewById<TextView>(R.id.txtVote)
        val description = layout.findViewById<TextView>(R.id.txtDescription)
        val date = layout.findViewById<TextView>(R.id.txtDate)
        val imageView = layout.findViewById<ImageView>(R.id.imgImageId)
        title.text = list!!.results!![position].title
        vote.text = java.lang.String.valueOf(list!!.results!![position].voteAverage)
        description.text = list!!.results!![position].overview
        date.text = list!!.results!![position].releaseDate
        Picasso.get().load(getImage(list!!.results!![position].posterPath)).into(imageView)
        return layout
    }

    companion object {
        fun getImage(name: String?): String {
            return "https://image.tmdb.org/t/p/w300$name"
        }
    }

    init {
        this.list = list
    }
}