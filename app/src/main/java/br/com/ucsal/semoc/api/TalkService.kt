package br.com.ucsal.semoc.api

import br.com.ucsal.semoc.model.Talk
import retrofit2.Call
import retrofit2.http.GET

interface TalkService {
    @GET("palestras.json")
    fun getTalks(): Call<List<Talk>>
}