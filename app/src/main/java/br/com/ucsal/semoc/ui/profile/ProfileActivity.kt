package br.com.ucsal.semoc.ui.profile

import android.app.Activity
import android.os.Bundle
import br.com.ucsal.semoc.R


class ProfileActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
//
        val extras = intent.extras
//        val talk = extras?.getSerializable("talk") as Talk
//
//        val descriptionTextView = findViewById<TextView>(R.id.description_talk_detail)
//        val dateTextView = findViewById<TextView>(R.id.date_talk_detail)
//        val timeTextView = findViewById<TextView>(R.id.time_talk_detail)
//        val locationTextView = findViewById<TextView>(R.id.location_talk_detail)
//        val themeTextView = findViewById<TextView>(R.id.theme_talk_detail)
//        val levelTextView = findViewById<TextView>(R.id.level_talk_detail)
//        val formatTextView = findViewById<TextView>(R.id.format_talk_detail)
//        val speakerTextView = findViewById<TextView>(R.id.speaker_talk_detail)
//
//        val boldSpan = StyleSpan(Typeface.BOLD)
//
//
//        descriptionTextView.text = talk.descricao
//
//        val date = SpannableStringBuilder("Data: ${talk.data.formatDateInBrazilianFormat()}")
//        date.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//        dateTextView.text = date
//
//        val time = SpannableStringBuilder("Hora: ${talk.hora}")
//        time.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//        timeTextView.text = time
//
//        val location = SpannableStringBuilder("Local: ${talk.local}")
//        location.setSpan(boldSpan, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//        locationTextView.text = location
//
//        val theme = SpannableStringBuilder("Tema: ${talk.tema}")
//        theme.setSpan(boldSpan, 0, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//        themeTextView.text = theme
//
//        val level = SpannableStringBuilder("Nível: ${talk.nivel}")
//        level.setSpan(boldSpan, 0, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//        levelTextView.text = level
//
//        val format = SpannableStringBuilder("Formato: ${talk.formato}")
//        format.setSpan(boldSpan, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
//        formatTextView.text = format
//
//
//        val backButton = findViewById<ImageView>(R.id.back_button_talk_detail)
//        backButton.setOnClickListener {
//            finish()
//        }

    }
}