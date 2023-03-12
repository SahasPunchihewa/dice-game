package com.sahas.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)
    }

    fun onThrow(view: View) {
        var player: List<Int> = generateNumbers()
        var computer: List<Int> = generateNumbers()



    }

    fun onScore(view: View) {

    }

    fun generateNumbers(): List<Int> {
        return List(5) {
            (1..6).random()
        }
    }
}