package com.rapitechsolution.moviedbapp.module.detail

import com.rapitechsolution.moviedbapp.adapters.interfaces.InteractorInterface
import com.rapitechsolution.moviedbapp.adapters.interfaces.RouterInterface
import com.rapitechsolution.moviedbapp.adapters.interfaces.ViewInterface
import com.rapitechsolution.moviedbapp.interfaces.PresenterInterface
import com.rapitechsolution.moviedbapp.models.Movie

interface DetailInterface {
    interface View : ViewInterface {
        fun reloadView(movieItem: Movie.MovieItem)
    }

    interface Presenter : PresenterInterface {
        val movieItem: Movie.MovieItem?
    }

    interface Interactor : InteractorInterface {}

    interface Router : RouterInterface {}
}