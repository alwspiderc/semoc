package br.com.ucsal.semoc.repository

import br.com.ucsal.semoc.model.Talk
import retrofit2.Call

class MinicourseRepository {

    private val minicourseApi: MinicourseApi

    init {
        val retrofit = RetrofitInstance.getRetrofitInstance()
        minicourseApi = retrofit.create(MinicourseApi::class.java)
    }

    fun getMinicourses(): Call<List<Talk>> {
        return minicourseApi.getTalks()
    }
}