package com.sahas.dicegame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class GameActivity : AppCompatActivity() {

    private lateinit var cLUserRow1: ConstraintLayout
    private lateinit var cLUserRow2: ConstraintLayout
    private lateinit var cLUserRow3: ConstraintLayout

    private lateinit var cLAIRow1: ConstraintLayout
    private lateinit var cLAIRow2: ConstraintLayout
    private lateinit var cLAIRow3: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        cLUserRow1 = findViewById(R.id.constraintLayoutDiceUserRow1)
        cLUserRow2 = findViewById(R.id.constraintLayoutDiceUserRow2)
        cLUserRow3 = findViewById(R.id.constraintLayoutDiceUserRow3)

        cLAIRow1 = findViewById(R.id.constraintLayoutDiceAIRow1)
        cLAIRow2 = findViewById(R.id.constraintLayoutDiceAIRow2)
        cLAIRow3 = findViewById(R.id.constraintLayoutDiceAIRow3)
    }

    fun onThrow(view: View) {
        Log.d("INFO", view.toString())
        val player: List<Int> = generateNumbers()
        val computer: List<Int> = generateNumbers()

        renderUserRoll(player)
        renderAIRoll(computer)
    }

    fun onScore(view: View) {

    }

    private fun generateNumbers(): List<Int> {
        return List(5) {
            (1..6).random()
        }
    }

    private fun getDiceResourceId(number: Int): Int {
        return when (number) {
            1 -> return R.drawable.die_face_1
            2 -> return R.drawable.die_face_2
            3 -> return R.drawable.die_face_3
            4 -> return R.drawable.die_face_4
            5 -> return R.drawable.die_face_5
            6 -> return R.drawable.die_face_6
            else -> throw IllegalArgumentException("Invalid dice number: $number")
        }
    }

    private fun centerVerticallyAndApply(imageId: Int, constraints: ConstraintSet, parent: ConstraintLayout) {
        constraints.connect(imageId, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        constraints.connect(imageId, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
        constraints.applyTo(parent)
    }

    private fun renderUserRoll(numbers: List<Int>) {
        var count = 1
        for (number in numbers) {
            val diceImage = ImageView(this)
            val imageResource = getDiceResourceId(number)

            diceImage.setImageResource(imageResource)
            diceImage.layoutParams = ConstraintLayout.LayoutParams(200, 200)

            when (count) {
                1 -> {
                    val constraints = ConstraintSet()
                    constraints.clone(cLUserRow1)
                    diceImage.id = R.id.user_die_1
                    cLUserRow1.addView(diceImage)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, cLUserRow1.id, ConstraintSet.LEFT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLUserRow1)
                }
                2 -> {
                    diceImage.id = R.id.user_die_2
                    cLUserRow1.addView(diceImage)

                    val constraints = ConstraintSet()
                    constraints.clone(cLUserRow1)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, R.id.user_die_1, ConstraintSet.RIGHT, 0)
                    constraints.connect(diceImage.id, ConstraintSet.RIGHT, cLUserRow1.id, ConstraintSet.RIGHT, 0)
                    constraints.connect(R.id.user_die_1, ConstraintSet.RIGHT, diceImage.id, ConstraintSet.LEFT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLUserRow1)
                }
                3 -> {
                    diceImage.id = R.id.user_die_3
                    cLUserRow2.addView(diceImage)

                    val constraints = ConstraintSet()
                    constraints.clone(cLUserRow2)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, cLUserRow2.id, ConstraintSet.LEFT, 0)
                    constraints.connect(diceImage.id, ConstraintSet.RIGHT, cLUserRow2.id, ConstraintSet.RIGHT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLUserRow2)
                }
                4 -> {
                    diceImage.id = R.id.user_die_4
                    cLUserRow3.addView(diceImage)

                    val constraints = ConstraintSet()
                    constraints.clone(cLUserRow3)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, cLUserRow3.id, ConstraintSet.LEFT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLUserRow3)
                }
                5 -> {
                    diceImage.id = R.id.user_die_5
                    cLUserRow3.addView(diceImage)

                    val constraints = ConstraintSet()
                    constraints.clone(cLUserRow3)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, R.id.user_die_4, ConstraintSet.RIGHT, 0)
                    constraints.connect(diceImage.id, ConstraintSet.RIGHT, cLUserRow3.id, ConstraintSet.RIGHT, 0)
                    constraints.connect(R.id.user_die_4, ConstraintSet.RIGHT, diceImage.id, ConstraintSet.LEFT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLUserRow3)
                }
            }
            count++
        }
    }

    private fun renderAIRoll(numbers: List<Int>) {
        var count = 1
        for (number in numbers) {
            val diceImage = ImageView(this)
            val imageResource = getDiceResourceId(number)

            diceImage.setImageResource(imageResource)
            diceImage.layoutParams = ConstraintLayout.LayoutParams(200, 200)

            when (count) {
                1 -> {
                    val constraints = ConstraintSet()
                    constraints.clone(cLAIRow1)
                    diceImage.id = R.id.user_die_1
                    cLAIRow1.addView(diceImage)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, cLUserRow1.id, ConstraintSet.LEFT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLAIRow1)
                }
                2 -> {
                    diceImage.id = R.id.user_die_2
                    cLAIRow1.addView(diceImage)

                    val constraints = ConstraintSet()
                    constraints.clone(cLAIRow1)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, R.id.user_die_1, ConstraintSet.RIGHT, 0)
                    constraints.connect(diceImage.id, ConstraintSet.RIGHT, cLUserRow1.id, ConstraintSet.RIGHT, 0)
                    constraints.connect(R.id.user_die_1, ConstraintSet.RIGHT, diceImage.id, ConstraintSet.LEFT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLAIRow1)
                }
                3 -> {
                    diceImage.id = R.id.user_die_3
                    cLAIRow2.addView(diceImage)

                    val constraints = ConstraintSet()
                    constraints.clone(cLAIRow2)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, cLUserRow2.id, ConstraintSet.LEFT, 0)
                    constraints.connect(diceImage.id, ConstraintSet.RIGHT, cLUserRow2.id, ConstraintSet.RIGHT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLAIRow2)
                }
                4 -> {
                    diceImage.id = R.id.user_die_4
                    cLAIRow3.addView(diceImage)

                    val constraints = ConstraintSet()
                    constraints.clone(cLAIRow3)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, cLUserRow3.id, ConstraintSet.LEFT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLAIRow3)
                }
                5 -> {
                    diceImage.id = R.id.user_die_5
                    cLAIRow3.addView(diceImage)

                    val constraints = ConstraintSet()
                    constraints.clone(cLAIRow3)

                    constraints.connect(diceImage.id, ConstraintSet.LEFT, R.id.user_die_4, ConstraintSet.RIGHT, 0)
                    constraints.connect(diceImage.id, ConstraintSet.RIGHT, cLUserRow3.id, ConstraintSet.RIGHT, 0)
                    constraints.connect(R.id.user_die_4, ConstraintSet.RIGHT, diceImage.id, ConstraintSet.LEFT, 0)
                    centerVerticallyAndApply(diceImage.id, constraints, cLAIRow3)
                }
            }
            count++
        }
    }
}