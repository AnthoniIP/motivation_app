package com.ipsoft.motivation.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ipsoft.motivation.R
import com.ipsoft.motivation.infra.MotivationConstants
import com.ipsoft.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var securityPreferences: SecurityPreferences
    private lateinit var textName: TextView
    private lateinit var btnAll: ImageView
    private lateinit var btnAHappy: ImageView
    private lateinit var btnMorning: ImageView
    private lateinit var btnNewFrase: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar?.hide()
        }

        textName = findViewById(R.id.txt_nome)
        btnAll = findViewById(R.id.cat_all)
        btnAHappy = findViewById(R.id.cat_happy)
        btnMorning = findViewById(R.id.cat_morning)
        btnNewFrase = findViewById(R.id.btn_new_frase)

        securityPreferences = SecurityPreferences(this)



        textName.text = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        btnAll.setOnClickListener(this)
        btnAHappy.setOnClickListener(this)
        btnMorning.setOnClickListener(this)
        btnNewFrase.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_new_frase -> {
                handleNewPhrase()
            }
            R.id.cat_all -> {
                handleFilter(MotivationConstants.PHRASEFILTER.ALL)
            }
            R.id.cat_happy -> {
                handleFilter(MotivationConstants.PHRASEFILTER.HAPPY)

            }
            R.id.cat_morning -> {
                handleFilter(MotivationConstants.PHRASEFILTER.MORNING)

            }

        }
    }

    private fun handleFilter(id: Int) {

        btnAll.setColorFilter(resources.getColor(R.color.white))
        btnAHappy.setColorFilter(resources.getColor(R.color.white))
        btnMorning.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            MotivationConstants.PHRASEFILTER.ALL -> {
                btnAll.setColorFilter(resources.getColor(R.color.purple_200))

            }
            MotivationConstants.PHRASEFILTER.HAPPY -> {
                btnAHappy.setColorFilter(resources.getColor(R.color.purple_200))

            }
            MotivationConstants.PHRASEFILTER.MORNING -> {
                btnMorning.setColorFilter(resources.getColor(R.color.purple_200))

            }

        }
    }

    private fun handleNewPhrase() {
        TODO("Not yet implemented")
    }
}