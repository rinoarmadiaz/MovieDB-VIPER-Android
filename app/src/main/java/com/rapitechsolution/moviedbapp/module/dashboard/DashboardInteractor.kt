package com.rapitechsolution.moviedbapp.module.dashboard

import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.rapitechsolution.moviedbapp.models.Movie

class DashboardInteractor : DashboardInterface.Interactor {
    val domainUrlString =
        "https://api.themoviedb.org/3/movie/popular?api_key=d670697d2e3f22a294bd761c88c3354f&language=en-US&page=1"

    override fun fetchMovieList(completion: (movieList: List<Movie.MovieItem>?) -> Unit) {
        domainUrlString.httpPost().responseObject(Movie.Deserializer()) { _, _, result ->
            when (result) {
                is Result.Success -> {
                    completion(result.component1()?.results)
                }
                is Result.Failure -> {
                    completion(null)
                }
            }
        }
    }
}