package br.com.ucsal.semoc.ui.minicourse

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import br.com.ucsal.semoc.R
import br.com.ucsal.semoc.api.PrifileService
import br.com.ucsal.semoc.api.RetrofitInstance
import br.com.ucsal.semoc.model.Minicourse
import br.com.ucsal.semoc.model.Profile
import br.com.ucsal.semoc.ui.profile.ProfileActivity
import br.com.ucsal.semoc.utils.formatDateInBrazilianFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MinicourseDetailActivity: Activity() {
    private var speaker: Profile? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minicourse_detail)

        val extras = intent.extras
        val minicourse = extras?.getSerializable("minicourse") as Minicourse

        val titleTextView = findViewById<TextView>(R.id.back_text_minicourse_detail)
        val descriptionTextView = findViewById<TextView>(R.id.description_minicourse_detail)
        val dateTextView = findViewById<TextView>(R.id.date_minicourse_detail)
        val timeTextView = findViewById<TextView>(R.id.time_minicourse_detail)
        val locationTextView = findViewById<TextView>(R.id.location_minicourse_detail)
        val themeTextView = findViewById<TextView>(R.id.theme_minicourse_detail)
        val levelTextView = findViewById<TextView>(R.id.level_minicourse_detail)
        val formatTextView = findViewById<TextView>(R.id.format_minicourse_detail)
        val speakerTextView = findViewById<TextView>(R.id.speaker_minicourse_detail)
        val subscribeButton = findViewById<Button>(R.id.subscribe_minicourse_detail)

        val boldSpan = StyleSpan(Typeface.BOLD)

        titleTextView.text = minicourse.nome.replace("Minicurso: ", "")
        descriptionTextView.text = minicourse.descricao

        val date = SpannableStringBuilder("Data: ${minicourse.data.formatDateInBrazilianFormat()}")
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


        val retrofit = RetrofitInstance.getRetrofitInstance()
        val profileService = retrofit.create(PrifileService::class.java)

        profileService.getProfile(minicourse.instrutor_id).enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                if (response.isSuccessful) {
                    speaker = response.body()
                    val profile = SpannableStringBuilder("Instrutor: ${speaker?.nome}")
                    profile.setSpan(boldSpan, 0, 11, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    speakerTextView.text = profile
                } else {
                    Toast.makeText(this@MinicourseDetailActivity, "Falha ao tentar carregar perfil do instrutor", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                Toast.makeText(this@MinicourseDetailActivity, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


        subscribeButton.setOnClickListener {
            speaker?.let {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("profile", it)
                startActivity(intent)
            }
        }

        val backButton = findViewById<ImageView>(R.id.back_button_minicourse_detail)
        backButton.setOnClickListener {
            finish()
        }
    }
}