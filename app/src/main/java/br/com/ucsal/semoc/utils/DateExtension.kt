package br.com.ucsal.semoc.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatDateInBrazilianFormat(): String {
    val dateWithSlashes = addSlashesToDate(this)

    val originalFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val targetFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    val date = originalFormat.parse(dateWithSlashes)
    return targetFormat.format(date).toString()
}

fun String.formatDateInUSFormat(): String {
    val originalFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    val targetFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val dateObj = originalFormat.parse(this)
    return  targetFormat.format(dateObj).toString()
}

fun addSlashesToDate(date: String): String {
    val cleanedDate = date.replace("/", "")
    if (cleanedDate.length == 8) {
        return cleanedDate.substring(0, 2) + "/" + cleanedDate.substring(2, 4) + "/" + cleanedDate.substring(4)
    }

    return date
}