package ru.s.ottusapp.filmsActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.s.ottusapp.R

class Film1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film1)
    }

    fun btnInviteFilm1(view: View?) {
        Log.d("1", "inv")
        val message = "Пошли в кино на ..."
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.type = "text/plain"

        sendIntent.resolveActivity(packageManager)?.let {
            startActivity(sendIntent)
        }
    }
   }
