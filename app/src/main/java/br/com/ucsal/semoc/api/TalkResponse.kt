package br.com.ucsal.semoc.api

import java.util.Date

data class TalkResponse(val id: String, val name: String, val description: String, val date: Date,
                        val hour: String, val locale: String, val speaker: String, val teme: String,
                        val level: String, val format: String)
{

}
