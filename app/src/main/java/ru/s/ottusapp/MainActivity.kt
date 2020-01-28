package ru.s.ottusapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import ru.s.ottusapp.films.Film1
import ru.s.ottusapp.films.Film2
import ru.s.ottusapp.films.Film3
import ru.s.ottusapp.films.Film4

class MainActivity : AppCompatActivity() {
    val TAG = "LifeCycle"
    val SAV = "Save"
    private var btnTextClr = 0
    private var btn3TextClr = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Create")

       btnTextClr = button.currentTextColor
       btn3TextClr = button3.currentTextColor

   if (savedInstanceState != null) {

       btnTextClr = savedInstanceState.getInt("1")
       btn3TextClr = savedInstanceState.getInt("2")

       button.setTextColor(btnTextClr)
       button3.setTextColor(btn3TextClr)


            Log.d(SAV, " wr btnTextClr $btnTextClr")
            Log.d(SAV, " wr btn3TextClr $btn3TextClr")
       }

    }





    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        btnTextClr = savedInstanceState.getInt("1")
        btn3TextClr = savedInstanceState.getInt("2")

        button.setTextColor(btnTextClr)
        button3.setTextColor(btn3TextClr)

        Log.d(SAV, "onRes $btnTextClr")
        Log.d(SAV, "onRes $btn3TextClr")

    }



    override fun onSaveInstanceState(outState: Bundle) {

          outState.putInt("1", btnTextClr)
          outState.putInt("2", btn3TextClr)
        super.onSaveInstanceState(outState)

        Log.d(SAV, "onSave $btnTextClr")
        Log.d(SAV, "onSave $btn3TextClr")
    }


    fun buttonFilm1(view: View) {
    val intent = Intent(this@MainActivity, Film1::class.java)
        startActivity(intent)
        button.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
        btnTextClr = button.currentTextColor
        Log.d(SAV, "btn $btnTextClr")

    }

    fun buttonFilm2(view: View) {
        val intent = Intent(this@MainActivity, Film2::class.java)
        startActivity(intent)
        button2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))

    }

    fun buttonFilm3(view: View) {
        val intent = Intent(this@MainActivity, Film3::class.java)
        startActivity(intent)
        button3.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
        btn3TextClr = button3.currentTextColor
        Log.d(SAV, "btn $btn3TextClr")
    }
    fun buttonFilm4(view: View) {
        val intent = Intent(this@MainActivity,Film4::class.java)
        startActivity(intent)
        button4.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))

    }

}

