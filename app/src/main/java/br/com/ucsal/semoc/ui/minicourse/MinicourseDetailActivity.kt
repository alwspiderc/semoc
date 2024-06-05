package br.com.ucsal.semoc.ui.minicourse

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import br.com.ucsal.semoc.R
import br.com.ucsal.semoc.model.Minicourse
class MinicourseDetailActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minicourse_detail)

        val extras = intent.extras
        val minicourse = extras?.getSerializable("minicourse") as Minicourse

        val descriptionTextView = findViewById<TextView>(R.id.description_minicourse_detail)
        val dateTextView = findViewById<TextView>(R.id.date_minicourse_detail)
        val timeTextView = findViewById<TextView>(R.id.time_minicourse_detail)
        val locationTextView = findViewById<TextView>(R.id.location_minicourse_detail)
        val themeTextView = findViewById<TextView>(R.id.theme_minicourse_detail)
        val levelTextView = findViewById<TextView>(R.id.level_minicourse_detail)
        val formatTextView = findViewById<TextView>(R.id.format_minicourse_detail)
//        val speakerTextView = findViewById<TextView>(R.id.speaker_talk_detail)

        val boldSpan = StyleSpan(Typeface.BOLD)

        val description = SpannableStringBuilder("Descrição: ${minicourse.descricao}")
        description.setSpan(boldSpan, 0, 10, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        descriptionTextView.text = description

        val date = SpannableStringBuilder("Data: ${minicourse.data}")
        date.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        dateTextView.text = date

        val time = SpannableStringBuilder("Hora: ${minicourse.hora}")
        time.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        timeTextView.text = time

        val location = SpannableStringBuilder("Local: ${minicourse.local}")
        location.setSpan(boldSpan, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        locationTextView.text = location

        val theme = SpannableStringBuilder("Tema: ${minicourse.tema}")
        theme.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        themeTextView.text = theme

        val level = SpannableStringBuilder("Nível: ${minicourse.nivel}")
        level.setSpan(boldSpan, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        levelTextView.text = level

        val format = SpannableStringBuilder("Formato: ${minicourse.formato}")
        format.setSpan(boldSpan, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        formatTextView.text = format
//        speakerTextView.text = "Palestrante: ${talk.palestrante}"
    }
}