package com.rapitechsolution.moviedbapp.module.dashboard

import androidx.appcompat.app.AppCompatActivity
import com.rapitechsolution.moviedbapp.models.Movie
import kotlin.properties.Delegates

class DashboardPresenter(
    private var view: DashboardInterface.View? = null
) : DashboardInterface.Presenter {
    private var interactor: DashboardInterface.Interactor? = null
    private var router: DashboardInterface.Router? = null
    override var movieList: List<Movie.MovieItem>? by Delegates.observable(null) { _, _, _ ->
        view?.reloadView()
    }

    override fun onResume() {}

    override fun onCreate(activity: AppCompatActivity) {
        view = activity as DashboardActivity
        interactor = DashboardInteractor()
        router = DashboardRouter(activity)
        fetchMovieList()
    }

    override fun onDestroy() {
        view = null
        router = null
    }

    override fun onMovieClick(movie: Movie.MovieItem) {
        router?.navigateToDetail(movie)
    }

    private fun fetchMovieList() {
        interactor?.fetchMovieList { movieList: List<Movie.MovieItem>? ->
            this.movieList = movieList
        }
    }
}