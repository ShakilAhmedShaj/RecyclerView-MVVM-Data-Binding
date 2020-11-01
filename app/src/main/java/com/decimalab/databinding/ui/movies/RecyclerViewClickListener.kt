package com.decimalab.databinding.ui.movies

import android.view.View
import com.decimalab.databinding.model.Movie

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, movie: Movie)
}