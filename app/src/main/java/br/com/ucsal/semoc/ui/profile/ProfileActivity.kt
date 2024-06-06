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
                .load("https://images.unsplash.com/photo-1547425260-76bcadfb4f2c?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .into(profileImageView)
        }

        titleTextView.text = speaker.nome
        descriptionTextView.text = speaker.bio


        backButton.setOnClickListener {
            finish()
        }
    }

}