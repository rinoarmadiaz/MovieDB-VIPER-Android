package com.rapitechsolution.moviedbapp.module.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rapitechsolution.moviedbapp.R
import com.rapitechsolution.moviedbapp.models.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

class DetailActivity : AppCompatActivity(), DetailInterface.View {
    private var presenter = DetailPresenter()

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        presenter.onCreate(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val movie = intent.getParcelableExtra<Movie.MovieItem>("movieItem")
        presenter.movieItem = movie
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun reloadView(movieItem: Movie.MovieItem) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500${movieItem.backdrop_path}")
            .into(movie_image)
        title_text.text = movieItem.title
        description_text.text = movieItem.overview
        release_date_text.text = movieItem.release_date
        language_text.text = movieItem.original_language.toUpperCase(Locale.ROOT)
        rating_text.text = movieItem.vote_average.toString()
        title = movieItem.title
    }
}