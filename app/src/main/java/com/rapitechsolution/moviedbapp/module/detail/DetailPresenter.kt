package com.rapitechsolution.moviedbapp.module.detail

import androidx.appcompat.app.AppCompatActivity
import com.rapitechsolution.moviedbapp.models.Movie
import kotlin.properties.Delegates

class DetailPresenter : DetailInterface.Presenter {
    private var view: DetailInterface.View? = null
    private var interactor: DetailInterface.Interactor? = null
    private var router: DetailInterface.Router? = null
    override var movieItem: Movie.MovieItem? by Delegates.observable(null) { _, _, newValue ->
        newValue?.let { view?.reloadView(it) }
    }

    override fun onResume() {}

    override fun onCreate(activity: AppCompatActivity) {
        view = activity as DetailActivity
        interactor = DetailInteractor()
        router = DetailRouter(activity)
    }

    override fun onDestroy() {
        interactor = null
        router = null
    }
}