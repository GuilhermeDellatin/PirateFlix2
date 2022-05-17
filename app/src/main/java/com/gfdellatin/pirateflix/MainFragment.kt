package com.gfdellatin.pirateflix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.gfdellatin.pirateflix.remote.BaseResponse
import com.gfdellatin.pirateflix.remote.MovieResponse
import com.gfdellatin.pirateflix.remote.ServiceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment : Fragment() {

    private lateinit var movies: RecyclerView

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movies = view.findViewById(R.id.movies)

        getMovies()
    }

    private fun getMovies() {
        lifecycleScope.launch(Dispatchers.IO) {
            val value: BaseResponse<List<MovieResponse>> =
                ServiceProvider.service.getMovies(BuildConfig.tmdbToken)

            withContext(Dispatchers.Main) {
                movies.adapter = MoviesAdapter(value.results)
            }
        }
    }
}