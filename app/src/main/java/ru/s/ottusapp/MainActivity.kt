package ru.s.ottusapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import ru.s.ottusapp.films.Film1
import ru.s.ottusapp.films.Film2
import ru.s.ottusapp.films.Film3
import ru.s.ottusapp.films.Film4

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonFilm1(view: View) {
    val intent = Intent(this@MainActivity, Film1::class.java)
        startActivity(intent)
        button.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))

    }

    fun buttonFilm2(view: View) {
        val intent = Intent(this@MainActivity, Film2::class.java)
        startActivity(intent)
        button2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))

    }

    fun buttonFilm3(view: View) {
        val intent = Intent(this@MainActivity, Film3::class.java)
        startActivity(intent)
        button.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))

    }
    fun buttonFilm4(view: View) {
        val intent = Intent(this@MainActivity,Film4::class.java)
        startActivity(intent)
        button.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))

    }
}
