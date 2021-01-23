package com.ipsoft.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ipsoft.motivation.R
import com.ipsoft.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnStart: Button
    private lateinit var editName: EditText
    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        securityPreferences = SecurityPreferences(this)


        if (supportActionBar != null) {
            supportActionBar?.hide()
        }

        editName = findViewById(R.id.edt_name)
        btnStart = findViewById(R.id.btn_start)

        btnStart.setOnClickListener(this)


    }

    override fun onClick(v: View) {

        val id = v.id
        if (id == R.id.btn_start) {
            handleSave()
        }
    }

    private fun handleSave() {

        val name = editName.text.toString()

        if (name.isNotEmpty()) {


            securityPreferences.storeString("name", name)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        } else {

            Toast.makeText(this, "Por favor insira seu nome.", Toast.LENGTH_SHORT).show()

        }


    }

}



