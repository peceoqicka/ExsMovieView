package com.em.exsmovieview.main

import android.view.View
import com.em.exsmovieview.R
import com.em.exsmovieview.binding.BaseBindingAdapter
import com.em.exsmovieview.data.MovieViewModel
import com.em.exsmovieview.databinding.ItemMovieBinding
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/1/26
 *      desc    :
 *      version :   1.0
 * </pre>
 */
class MovieAdapter(data: List<MovieViewModel>) : BaseBindingAdapter<MovieViewModel, ItemMovieBinding>(data) {
    override fun getLayoutId(viewType: Int): Int = R.layout.item_movie

    override fun onSetData(binding: ItemMovieBinding, data: MovieViewModel) {
        binding.model = data
    }

    override fun onItemClick(itemView: View, data: MovieViewModel) {
        println("onItemClick")
    }
}