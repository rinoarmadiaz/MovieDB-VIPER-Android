package com.rapitechsolution.moviedbapp.adapters

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rapitechsolution.moviedbapp.R
import com.rapitechsolution.moviedbapp.models.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cell_movie.view.*

class MovieAdapter(
    private var movieList: List<Movie.MovieItem>?,
    private var onClickListener: (Movie.MovieItem?) -> Unit
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var view: View = itemView

        fun bindView(movie: Movie.MovieItem?) {
            view.cell_movie_title.text = movie?.title
            view.cell_movie_title.maxLines = 1
            view.cell_movie_title.ellipsize = TextUtils.TruncateAt.END
            view.cell_movie_subtitle.text = movie?.overview
            view.cell_movie_subtitle.maxLines = 3
            view.cell_movie_subtitle.ellipsize = TextUtils.TruncateAt.END
            Picasso.get().load("https://image.tmdb.org/t/p/w500${movie?.poster_path}")
                .into(view.cell_movie_image)
            view.cell_container.setOnClickListener {
                onClickListener(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPhoto = movieList?.get(position)
        holder.bindView(itemPhoto)
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }

    fun updateData(movieList: List<Movie.MovieItem>?) {
        this.movieList = movieList
        this.notifyDataSetChanged()
    }
}