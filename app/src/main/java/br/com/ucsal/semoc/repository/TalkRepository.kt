package br.com.ucsal.semoc.repository

import br.com.ucsal.semoc.api.RetrofitInstance
import br.com.ucsal.semoc.api.TalkService
import br.com.ucsal.semoc.model.Talk
import retrofit2.Call

class TalkRepository {
    private val talkService: TalkService

    init {
        val retrofit = RetrofitInstance.getRetrofitInstance()
        talkService = retrofit.create(TalkService::class.java)
    }

    fun getTalks(): Call<List<Talk>> {
        return talkService.getTalks()
    }
}