package com.decimalab.databinding.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.decimalab.databinding.R
import com.decimalab.databinding.databinding.RecyclerviewMovieBinding
import com.decimalab.databinding.model.Movie

class MoviesAdapter(
    private val movies: List<Movie>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie = movies[position]
        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
            listener.onRecyclerViewItemClick(
                holder.recyclerviewMovieBinding.buttonBook,
                movies[position]
            )
        }
        holder.recyclerviewMovieBinding.layoutLike.setOnClickListener {
            listener.onRecyclerViewItemClick(
                holder.recyclerviewMovieBinding.layoutLike,
                movies[position]
            )
        }
    }


    inner class MoviesViewHolder(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)

}