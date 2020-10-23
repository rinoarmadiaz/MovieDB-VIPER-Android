package com.rapitechsolution.moviedbapp.module.dashboard

import android.content.Intent
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.rapitechsolution.moviedbapp.module.detail.DetailActivity
import com.rapitechsolution.moviedbapp.models.Movie

class DashboardRouter(override val activity: AppCompatActivity) :
    DashboardInterface.Router {

    override fun navigateToDetail(movie: Movie.MovieItem) {
        val intent = Intent(
            activity.applicationContext,
            DetailActivity::class.java
        ).putExtra("movieItem", movie)
        activity.startActivity(intent)
    }
}