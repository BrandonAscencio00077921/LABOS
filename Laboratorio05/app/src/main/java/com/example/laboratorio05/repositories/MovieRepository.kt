package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.movies

class MovieRepository(private val repository: MutableList<MovieModel>){

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)

}