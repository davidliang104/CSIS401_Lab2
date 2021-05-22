package com.example.csis401lab2

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Starts intent to go to the game
    fun startGame(view: View) {
        val intent = Intent(this, TicTacToe::class.java)
        startActivity(intent)
    }

    // Displays alert that can quit the app
    fun quitGame(view:View) {
        val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("Are you sure you want to quit?")

        alertDialogBuilder.setNegativeButton("No",
            DialogInterface.OnClickListener { dialog, which ->
                Log.i("david", "Pressed No")
            })

        alertDialogBuilder.setPositiveButton("Yes",
            DialogInterface.OnClickListener { dialog, which ->
                Log.i("david", "Pressed Yes")
                finish()
                System.exit(0)
            })
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}