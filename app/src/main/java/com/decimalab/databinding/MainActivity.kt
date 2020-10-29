package com.decimalab.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.decimalab.databinding.network.MoviesApi
import com.decimalab.databinding.repositories.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MoviesRepository(MoviesApi())

        GlobalScope.launch(Dispatchers.Main) {
            val movies = repository.getMovies()
            Toast.makeText(this@MainActivity, movies.toString(), Toast.LENGTH_SHORT).show()
        }

    }
}