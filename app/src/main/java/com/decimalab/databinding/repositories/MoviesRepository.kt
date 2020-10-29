package com.decimalab.databinding.repositories

import com.decimalab.databinding.network.MoviesApi


class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }

}