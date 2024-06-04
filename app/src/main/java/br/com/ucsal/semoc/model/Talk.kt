package br.com.ucsal.semoc.model

data class Talk(
    val id: Int,
    val nome: String,
    val descricao: String,
    val data: String,
    val hora: String,
    val local: String,
    val palestrante_id: Int,
    val tema: String,
    val nivel: String,
    val formato: String
)
