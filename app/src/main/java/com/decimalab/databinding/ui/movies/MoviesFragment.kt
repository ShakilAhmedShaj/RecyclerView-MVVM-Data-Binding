package com.decimalab.databinding.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.decimalab.databinding.R
import com.decimalab.databinding.model.Movie
import com.decimalab.databinding.network.MoviesApi
import com.decimalab.databinding.repositories.MoviesRepository
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(), RecyclerViewClickListener {

    companion object {
        const val TAG = "MoviesFragment"
    }

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = MoviesApi()
        val repository = MoviesRepository(api)

        factory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MoviesViewModel::class.java)

        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(movies, this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when (view.id) {
            R.id.button_book -> {
                Toast.makeText(requireContext(), "Book Button Clicked", Toast.LENGTH_LONG).show()
            }
            R.id.layout_like -> {
                Toast.makeText(requireContext(), "Like Layout Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

}