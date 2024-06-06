package br.com.ucsal.semoc.api

import br.com.ucsal.semoc.model.Minicourse
import br.com.ucsal.semoc.model.Profile
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PrifileService {
    @GET("pessoas/{id}.json")
    fun getProfile(@Path("id") id: Int): Call<Profile>
}