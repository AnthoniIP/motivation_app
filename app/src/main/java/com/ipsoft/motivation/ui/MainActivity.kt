package com.ipsoft.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ipsoft.motivation.R
import com.ipsoft.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var securityPreferences : SecurityPreferences
    private lateinit var textName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textName = findViewById(R.id.txt_nome)

        securityPreferences = SecurityPreferences(this)

        val name = securityPreferences.getString("name")

        textName.text = name.toString()

    }
}