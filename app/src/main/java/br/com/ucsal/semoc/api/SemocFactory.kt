package br.com.ucsal.semoc.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
class SemocFactory {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/ucsal/semoc/main/api")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
}