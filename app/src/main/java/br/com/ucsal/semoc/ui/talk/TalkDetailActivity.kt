package br.com.ucsal.semoc.ui.talk

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import br.com.ucsal.semoc.R
import br.com.ucsal.semoc.api.PrifileService
import br.com.ucsal.semoc.api.RetrofitInstance
import br.com.ucsal.semoc.model.Profile
import br.com.ucsal.semoc.model.Talk
import br.com.ucsal.semoc.utils.formatDateInBrazilianFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val speakerTextView = findViewById<TextView>(R.id.speaker_talk_detail)

        val boldSpan = StyleSpan(Typeface.BOLD)


        descriptionTextView.text = talk.descricao

        val date = SpannableStringBuilder("Data: ${talk.data.formatDateInBrazilianFormat()}")
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

        val retrofit = RetrofitInstance.getRetrofitInstance()
        val profileService = retrofit.create(PrifileService::class.java)

        profileService.getProfile(talk.palestrante_id).enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                if (response.isSuccessful) {
                    val speaker = response.body()
                    val profile = SpannableStringBuilder("Palestrante: ${speaker?.nome}")
                    profile.setSpan(boldSpan, 0, 11, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    speakerTextView.text = profile
                } else {

                }
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
            }
        })




        val backButton = findViewById<ImageView>(R.id.back_button_talk_detail)
        backButton.setOnClickListener {
            finish()
        }

    }
}