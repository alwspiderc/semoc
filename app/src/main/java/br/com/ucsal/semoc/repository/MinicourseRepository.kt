package br.com.ucsal.semoc.repository

import br.com.ucsal.semoc.api.MinicourseService
import br.com.ucsal.semoc.api.RetrofitInstance
import br.com.ucsal.semoc.model.Minicourse
import br.com.ucsal.semoc.model.Talk
import retrofit2.Call

class MinicourseRepository {

    private val minicourseService: MinicourseService

    init {
        val retrofit = RetrofitInstance.getRetrofitInstance()
        minicourseService = retrofit.create(MinicourseService::class.java)
    }

    fun getMinicourses(): Call<List<Minicourse>> {
        return minicourseService.getMinicourses()
    }
}