package com.example.csis401lab2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TableRow
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tic_tac_toe.*

class TicTacToe : AppCompatActivity() {
    // Initialize a variable to count the turns
    var turn: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        /*
        * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
        * performs a swipe-to-refresh gesture.
        */
        swiperefresh.setOnRefreshListener {
            Log.i("david", "onRefresh called from SwipeRefreshLayout")
            refreshPage()
        }

    }

    fun selectButton(view: View) {
        // Set the color and text based on whose turn it is
        val color: Int
        val letter: String
        if (turn % 2 == 1) {
            color = R.color.red
            letter = "X"
        } else {
            color = R.color.blue
            letter = "O"
        }
        // Cast the view to a Button object
        val btn: Button = view as Button
        // Make button unclickable
        btn.isClickable = false
        // Change background color of button
        btn.setBackgroundColor(resources.getColor(color))
        // Set text inside button
        btn.text = letter
        // Check for win or draw
        checkBoard()
        // Increment the turn counter
        turn++
    }

    // Function to evaluate for a win or draw
    fun checkBoard() {
        // Check rows for win
        if (b1.text.equals(b2.text) && b1.text.equals(b3.text) && !b1.text.equals("")) {
            endGame("win")
        } else if (b4.text.equals(b5.text) && b4.text.equals(b6.text) && !b4.text.equals("")) {
            endGame("win")
        } else if (b7.text.equals(b8.text) && b7.text.equals(b9.text) && !b7.text.equals("")) {
            endGame("win")
        }
        // Check columns for win
        else if (b1.text.equals(b4.text) && b1.text.equals(b7.text) && !b1.text.equals("")) {
            endGame("win")
        } else if (b2.text.equals(b5.text) && b2.text.equals(b8.text) && !b2.text.equals("")) {
            endGame("win")
        } else if (b3.text.equals(b6.text) && b3.text.equals(b9.text) && !b3.text.equals("")) {
            endGame("win")
        }
        // Check diagonals for win
        else if (b1.text.equals(b5.text) && b1.text.equals(b9.text) && !b1.text.equals("")) {
            endGame("win")
        } else if (b3.text.equals(b5.text) && b3.text.equals(b7.text) && !b3.text.equals("")) {
            endGame("win")
        }
        // Check if board is full and declares a draw if true
        else if (b1.text.isNotBlank() && b2.text.isNotBlank() && b3.text.isNotBlank() && b4.text.isNotBlank()
            && b5.text.isNotBlank() && b6.text.isNotBlank() && b7.text.isNotBlank() && b8.text.isNotBlank()
            && b9.text.isNotBlank()
        ) {
            endGame("draw")
        }
    }

    // Function to display the result and close the game
    fun endGame(type: String) {
        // Loop through all buttons and make them unclickable
        for (i in 0 until gameBoard.getChildCount()) {
            val row: TableRow = gameBoard.getChildAt(i) as TableRow
            // Iterate through the table row.
            for (j in 0 until row.getChildCount()) {
                val btn = row.getChildAt(j) as Button
                btn.isClickable = false
            }
        }

        if (type.equals("win")) {
            // Check whose turn it is and display the victory message
            val player: Int
            if (turn % 2 == 1) {
                player = 1
            } else {
                player = 2
            }
            result.text = "Player $player wins!"
        } else if (type.equals("draw")) {
            // Display draw message
            result.text = "Draw!"
        }
    }

    // Refresh the page after swiping down
    fun refreshPage() {
        finish();
        startActivity(getIntent());
    }
}