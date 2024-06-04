package br.com.ucsal.semoc.model

data class Minicourse(
    val id: Int,
    val nome: String,
    val descricao: String,
    val data: String,
    val hora: String,
    val local: String,
    val instrutor_id: Int,
    val tema: String,
    val nivel: String,
    val formato: String
)
