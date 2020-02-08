package com.brunocortez.placapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brunocortez.placapp.R
import com.brunocortez.placapp.ui.game.GameActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btNewGame.setOnClickListener { newGamePressed() }
        btExit.setOnClickListener { exitPressed() }
    }

    private fun newGamePressed() {
        startActivity(Intent(this, GameActivity::class.java))
    }

    private fun exitPressed() {
        finish()
    }
}
