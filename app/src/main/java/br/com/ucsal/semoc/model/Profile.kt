package br.com.ucsal.semoc.model

import java.io.Serializable

//{
//    "id": 1,
//    "nome": "Comit\u00ea Organizador SEMOC",
//    "bio": "Respons\u00e1vel pela organiza\u00e7\u00e3o e realiza\u00e7\u00e3o do evento SEMOC.",
//    "tipo": "organizacao",
//    "foto_url": "https://ucsal.github.io/semoc/imagem/comite-organizador.png"
//}

data class Profile(
    val id: Int,
    val nome: String,
    val bio: String,
    val tipo: String,
    val foto_url: String
) : Serializable
