package com.gfdellatin.pirateflix.presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.gfdellatin.pirateflix.R

class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(viewLifecycleOwner) {
            recyclerView.adapter = MoviesAdapter(it)
        }

        recyclerView = view.findViewById(R.id.movies)
        viewModel.getMovies()
    }

}