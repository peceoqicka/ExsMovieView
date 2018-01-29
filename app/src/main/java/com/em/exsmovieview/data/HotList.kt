package com.em.exsmovieview.data

/**
 * <pre>
 *      author  :   Acer
 *      e-mail  :   xx@xxx
 *      time    :   2018/1/22
 *      desc    :
 *      version :   1.0
 * </pre>
 */
data class HotList(var control: Control, var status: Int, var data: MovieData) {
    data class Control(var expires: Int)
    data class MovieData(var hasNext: Boolean, var movies: List<Movie>)
    data class Movie(var id: Long, var nm: String/*标题*/,
                     var star: String/*主演*/, var cat: String/*类型*/,
                     var sc: Double/*评分*/, var rt: String/*上映时间*/,
                     var img: String/*封面图*/)

    fun getMovieViewModelList(): List<MovieViewModel> {
        val list = ArrayList<MovieViewModel>()
        data.movies.mapTo(list, { m ->
            MovieViewModel().also { model ->
                model.title = m.nm
                model.mark = m.sc
                model.coverUrl = m.img
            }
        })
        return list
    }
}