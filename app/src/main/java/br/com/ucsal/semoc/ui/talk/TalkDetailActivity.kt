package br.com.ucsal.semoc.ui.talk

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import br.com.ucsal.semoc.R
import br.com.ucsal.semoc.model.Talk

class TalkDetailActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk_detail)

        val extras = intent.extras
        val talk = extras?.getSerializable("talk") as Talk

        val descriptionTextView = findViewById<TextView>(R.id.description_talk_detail)
        val dateTextView = findViewById<TextView>(R.id.date_talk_detail)
        val timeTextView = findViewById<TextView>(R.id.time_talk_detail)
        val locationTextView = findViewById<TextView>(R.id.location_talk_detail)
        val themeTextView = findViewById<TextView>(R.id.theme_talk_detail)
        val levelTextView = findViewById<TextView>(R.id.level_talk_detail)
        val formatTextView = findViewById<TextView>(R.id.format_talk_detail)
//        val speakerTextView = findViewById<TextView>(R.id.speaker_talk_detail)

        val boldSpan = StyleSpan(Typeface.BOLD)

        val description = SpannableStringBuilder("Descrição: ${talk.descricao}")
        description.setSpan(boldSpan, 0, 10, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        descriptionTextView.text = description

        val date = SpannableStringBuilder("Data: ${talk.data}")
        date.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        dateTextView.text = date

        val time = SpannableStringBuilder("Hora: ${talk.hora}")
        time.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        timeTextView.text = time

        val location = SpannableStringBuilder("Local: ${talk.local}")
        location.setSpan(boldSpan, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        locationTextView.text = location

        val theme = SpannableStringBuilder("Tema: ${talk.tema}")
        theme.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        themeTextView.text = theme

        val level = SpannableStringBuilder("Nível: ${talk.nivel}")
        level.setSpan(boldSpan, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        levelTextView.text = level

        val format = SpannableStringBuilder("Formato: ${talk.formato}")
        format.setSpan(boldSpan, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        formatTextView.text = format
//        speakerTextView.text = "Palestrante: ${talk.palestrante}"
    }
}