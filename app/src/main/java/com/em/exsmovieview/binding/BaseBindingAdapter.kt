package com.em.exsmovieview.binding

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * <pre>
 *      author  :   peceoqicka
 *      e-mail  :   ratchet@qq.com
 *      time    :   2017/09/21
 *      desc    :   通用适配器(DataBinding版),Kotlin version
 *      version :   1.0
 * </pre>
 */
abstract class BaseBindingAdapter<Data, in Binding>(val dataList: List<Data>) : RecyclerView.Adapter<BindingViewHolder>() where Binding : ViewDataBinding {
    protected abstract fun getLayoutId(viewType: Int): Int
    protected abstract fun onSetData(binding: Binding, data: Data)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val binding = DataBindingUtil.inflate<Binding>(LayoutInflater.from(parent.context),
                getLayoutId(viewType), parent, false)
        return BindingViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        DataBindingUtil.getBinding<Binding>(holder.itemView)?.let { binding ->
            onSetData(binding, dataList[position])
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int = dataList.size

    open fun onItemClick(itemView: View, data: Data) = Unit
}