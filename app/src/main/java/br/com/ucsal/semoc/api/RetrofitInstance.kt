package br.com.ucsal.semoc.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory;
object RetrofitInstance {

    private const val BASE_URL = "https://raw.githubusercontent.com/ucsal/semoc/main/api/"
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RetrofitInstance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
