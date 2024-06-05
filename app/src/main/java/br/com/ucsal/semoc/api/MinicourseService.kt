package br.com.ucsal.semoc.api

import br.com.ucsal.semoc.model.Minicourse
import br.com.ucsal.semoc.model.Talk
import retrofit2.Call
import retrofit2.http.GET

interface MinicourseService {
    @GET("minicursos.json")
    fun getMinicourses(): Call<List<Minicourse>>
}