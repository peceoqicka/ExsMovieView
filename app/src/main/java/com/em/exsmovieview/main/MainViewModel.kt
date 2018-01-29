package com.em.exsmovieview.main

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v7.widget.RecyclerView
import com.em.exsmovieview.BR

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/1/26
 *      desc    :
 *      version :   1.0
 * </pre>
 */
class MainViewModel : BaseObservable() {
    lateinit var layoutManager: RecyclerView.LayoutManager
    var rvAdapter: MovieAdapter? = null
        set(value) {
            field = value;notifyPropertyChanged(BR.rvAdapter)
        }
        @Bindable
        get
}