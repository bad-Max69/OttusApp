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

    private var btnTextClr = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Create")

       btnTextClr.add(button.currentTextColor)
       btnTextClr.add(button2.currentTextColor)
       btnTextClr.add(button3.currentTextColor)
       btnTextClr.add(button4.currentTextColor)


   if (savedInstanceState != null) {

       btnTextClr[0] = savedInstanceState.getInt("0")
       btnTextClr[1] = savedInstanceState.getInt("1")
       btnTextClr[2] = savedInstanceState.getInt("2")
       btnTextClr[3] = savedInstanceState.getInt("3")

       button.setTextColor(btnTextClr[0])
       button2.setTextColor(btnTextClr[1])
       button3.setTextColor(btnTextClr[2])
       button4.setTextColor(btnTextClr[3])


            Log.d(SAV, " wr btnTextClr ${btnTextClr[0]}")
            Log.d(SAV, " wr btn3TextClr ${btnTextClr[1]}")
       }

    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        btnTextClr[0] = savedInstanceState.getInt("0")
        btnTextClr[1] = savedInstanceState.getInt("1")
        btnTextClr[2] = savedInstanceState.getInt("2")
        btnTextClr[3] = savedInstanceState.getInt("3")

        button.setTextColor(btnTextClr[0])
        button2.setTextColor(btnTextClr[1])
        button3.setTextColor(btnTextClr[2])
        button4.setTextColor(btnTextClr[3])

        Log.d(SAV, "onRes ${btnTextClr[0]}")
        Log.d(SAV, "onRes ${btnTextClr[1]}")

    }



    override fun onSaveInstanceState(outState: Bundle) {

          outState.putInt("0", btnTextClr[0])
          outState.putInt("1", btnTextClr[1])
          outState.putInt("2", btnTextClr[2])
          outState.putInt("3", btnTextClr[3])
        super.onSaveInstanceState(outState)

        Log.d(SAV, "onSave ${btnTextClr[0]}")
        Log.d(SAV, "onSave ${btnTextClr[1]}")
    }


    fun buttonFilm1(view: View) {
    val intent = Intent(this@MainActivity, Film1::class.java)
        startActivity(intent)
        button.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
        btnTextClr[0] = button.currentTextColor
        Log.d(SAV, "btn ${btnTextClr[0]}")

    }

    fun buttonFilm2(view: View) {
        val intent = Intent(this@MainActivity, Film2::class.java)
        startActivity(intent)
        button2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        btnTextClr[1] = button2.currentTextColor
    }

    fun buttonFilm3(view: View) {
        val intent = Intent(this@MainActivity, Film3::class.java)
        startActivity(intent)
        button3.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
        btnTextClr[2] = button3.currentTextColor
        Log.d(SAV, "btn ${btnTextClr[3]}")
    }
    fun buttonFilm4(view: View) {
        val intent = Intent(this@MainActivity,Film4::class.java)
        startActivity(intent)
        button4.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
        btnTextClr[3] = button4.currentTextColor
    }

}

