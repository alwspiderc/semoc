package br.com.ucsal.semoc.repository
import br.com.ucsal.semoc.model.Talk
import retrofit2.Call
import retrofit2.http.GET
interface TalkApi {
    @GET("palestras.json")
    fun getTalks(): Call<List<Talk>>

}