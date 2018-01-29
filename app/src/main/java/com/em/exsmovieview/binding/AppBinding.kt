package com.em.exsmovieview.binding

import android.databinding.BindingAdapter
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.em.exsmovieview.R
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import org.jetbrains.anko.dimen

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

@BindingAdapter("bind:itemDecoration")
fun addItemDecoration(recyclerView: RecyclerView, itemDecoration: RecyclerView.ItemDecoration) {
    recyclerView.addItemDecoration(itemDecoration)
}

@BindingAdapter("bind:rvAdapter")
fun <Data, Binding> setRVAdapter(recyclerView: RecyclerView, adapter: BaseBindingAdapter<Data, Binding>?) where Binding : ViewDataBinding {
    adapter?.let { ad -> recyclerView.adapter = ad }
}

@BindingAdapter("bind:imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url)
            .apply(RequestOptions.bitmapTransform(
                    RoundedCornersTransformation(imageView.context.dimen(R.dimen.px_15), 0, RoundedCornersTransformation.CornerType.ALL)))
            .into(imageView)
}