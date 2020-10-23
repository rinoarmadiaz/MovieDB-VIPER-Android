import com.rapitechsolution.moviedbapp.adapters.interfaces.InteractorInterface
import com.rapitechsolution.moviedbapp.adapters.interfaces.RouterInterface
import com.rapitechsolution.moviedbapp.interfaces.PresenterInterface
import com.rapitechsolution.moviedbapp.models.Movie

interface DashboardInterface {

    interface View {
        fun reloadView()
    }

    interface Presenter : PresenterInterface {
        fun onMovieClick(movie: Movie.MovieItem)
        var movieList: List<Movie.MovieItem>?
    }

    interface Interactor : InteractorInterface {
        fun fetchMovieList(completion: (movieList: List<Movie.MovieItem>?) -> Unit)
    }

    interface Router : RouterInterface {
        fun navigateToDetail(movie: Movie.MovieItem)
    }
}