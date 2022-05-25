package com.gfdellatin.pirateflix.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gfdellatin.pirateflix.domain.use_case.GetMoviesUseCase
import com.gfdellatin.pirateflix.presenter.model.MovieViewObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
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