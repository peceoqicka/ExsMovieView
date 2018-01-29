package com.em.exsmovieview.data

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/1/22
 *      desc    :
 *      version :   1.0
 * </pre>
 */
interface HotListService {
    /**
     * http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000
     */
    @GET("list.json?type=hot&offset=0&limit=1000")
    fun getHotList(): Observable<HotList>
}