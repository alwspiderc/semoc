package br.com.ucsal.semoc.ui.profile

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.ucsal.semoc.R
import br.com.ucsal.semoc.model.Profile
import com.bumptech.glide.Glide


class ProfileActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val speaker = intent.getSerializableExtra("profile") as Profile

        val backButton = findViewById<ImageView>(R.id.back_button_profile_detail)

        val profileImageView = findViewById<ImageView>(R.id.image_profile)
        val titleTextView = findViewById<TextView>(R.id.title_profile)
        val descriptionTextView = findViewById<TextView>(R.id.description_profile)

        if (profileImageView != null) {
            Glide.with(this)
                .load(speaker.foto_url)
                .into(profileImageView)
        }

        titleTextView.text = speaker.nome
        descriptionTextView.text = speaker.bio


        backButton.setOnClickListener {
            finish()
        }
    }

}