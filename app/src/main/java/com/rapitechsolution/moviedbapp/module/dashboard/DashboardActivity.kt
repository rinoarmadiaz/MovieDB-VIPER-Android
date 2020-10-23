package com.rapitechsolution.moviedbapp.module.dashboard

import DashboardInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rapitechsolution.moviedbapp.R
import com.rapitechsolution.moviedbapp.adapters.MovieAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity(), DashboardInterface.View {
    private var presenter = DashboardPresenter(this)

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        presenter.onCreate(this)
        setupRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun reloadView() {
        val adapter = recyclerView.adapter as MovieAdapter
        adapter.updateData(presenter.movieList)
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        val adapter = MovieAdapter(null) { movieItem ->
            movieItem?.let { presenter.onMovieClick(it) }
        }
        recyclerView.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
    }
}
