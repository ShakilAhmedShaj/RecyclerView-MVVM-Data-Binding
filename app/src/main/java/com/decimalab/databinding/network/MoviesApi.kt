package com.decimalab.databinding.network

import com.decimalab.databinding.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("movies.json")
    suspend fun getMovies(): Response<List<Movie>>


    companion object {
        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://raw.githubusercontent.com/ShakilAhmedShaj/static_json_apis/master/")
                .build()
                .create(MoviesApi::class.java)
        }
    }
}
