package com.em.exsmovieview.data

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.em.exsmovieview.BR

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/1/25
 *      desc    :
 *      version :   1.0
 * </pre>
 */
class MovieViewModel : BaseObservable() {
    var title: String = ""
        set(value) {
            field = value;notifyPropertyChanged(BR.title)
        }
        @Bindable
        get
    var mark: Double = 0.0
        set(value) {
            field = value;notifyPropertyChanged(BR.mark)
        }
        @Bindable
        get
    var coverUrl: String = ""
        set(value) {
            field = value;notifyPropertyChanged(BR.coverUrl)
        }
        @Bindable
        get
}