package com.gfdellatin.pirateflix.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gfdellatin.pirateflix.domain.model.Movies
import com.gfdellatin.pirateflix.domain.model.use_case.GetMoviesUseCase
import com.gfdellatin.pirateflix.presenter.model.MovieViewObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieViewObject>>()
    val movies : LiveData<List<MovieViewObject>> = _movies

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            getMoviesUseCase().onSuccess { movies ->
                _movies.postValue(movies.map {
                    MovieViewObject(it)
                })
            }.onFailure {

            }
        }
    }
}