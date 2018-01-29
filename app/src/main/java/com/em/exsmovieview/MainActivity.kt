package com.em.exsmovieview

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.em.exsmovieview.data.HotList
import com.em.exsmovieview.data.HotListService
import com.em.exsmovieview.databinding.ActivityMainBinding
import com.em.exsmovieview.main.MainViewModel
import com.em.exsmovieview.main.MovieAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.info
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), AnkoLogger {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        info("onCreate")
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main)
        binding.model = MainViewModel().also { m ->
            m.layoutManager = LinearLayoutManager(this,
                    LinearLayoutManager.HORIZONTAL, false)
        }

        request()
    }

    private fun request() {
        info("request movie list")
        val retrofit =
                Retrofit.Builder().run {
                    baseUrl("http://m.maoyan.com/movie/")
                    addConverterFactory(GsonConverterFactory.create())
                    addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    build()
                }

        retrofit.create(HotListService::class.java)
                .getHotList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onFailure)
    }

    private fun onSuccess(hotList: HotList) {
        info("Request succeed : \n ${hotList.data}")
        with(hotList.getMovieViewModelList()) {
            binding.model?.let { m ->
                m.rvAdapter = MovieAdapter(this)
            }
        }
    }

    private fun onFailure(throwable: Throwable) {
        error("Request failed, ${throwable.message}")
    }
}
