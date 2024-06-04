package br.com.ucsal.semoc.repository

import br.com.ucsal.semoc.model.Talk
import retrofit2.Call

class TalkRepository {
    private val talkApi: TalkApi

    init {
        val retrofit = RetrofitInstance.getRetrofitInstance()
        talkApi = retrofit.create(TalkApi::class.java)
    }

    fun getTalks(): Call<List<Talk>> {
        return talkApi.getTalks()
    }
}