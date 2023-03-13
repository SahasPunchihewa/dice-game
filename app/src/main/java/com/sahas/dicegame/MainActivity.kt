package com.sahas.dicegame

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickAbout(view: View) {
        val aboutIntent = Intent(this, AboutPopup::class.java)
        startActivity(aboutIntent)
    }

    fun onClickNewGame(view: View) {
        val gameIntent = Intent(this, GameActivity::class.java)
        startActivity(gameIntent)
    }
}