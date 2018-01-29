package com.em.exsmovieview.binding

import android.databinding.BindingAdapter
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/1/26
 *      desc    :
 *      version :   1.0
 * </pre>
 */
@BindingAdapter("bind:layoutManager")
fun setLayoutManager(recyclerView: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    recyclerView.layoutManager = layoutManager
}

@BindingAdapter("bind:rvAdapter")
fun <Data, Binding> setRVAdapter(recyclerView: RecyclerView, adapter: BaseBindingAdapter<Data, Binding>?) where Binding : ViewDataBinding {
    adapter?.let { ad -> recyclerView.adapter = ad }
}

@BindingAdapter("bind:imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url)
            .into(imageView)
}