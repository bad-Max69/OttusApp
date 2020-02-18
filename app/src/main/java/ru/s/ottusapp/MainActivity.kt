package ru.s.ottusapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import ru.s.ottusapp.filmsActivity.Film1
import ru.s.ottusapp.filmsActivity.Film2
import ru.s.ottusapp.filmsActivity.Film3
import ru.s.ottusapp.filmsActivity.Film4

class MainActivity : AppCompatActivity() {
    val TAG = "LifeCycle"
    val SAV = "Save"

    private var btnTextClr = arrayListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Create")



        if (savedInstanceState != null) {

            btnTextClr = savedInstanceState.getIntegerArrayList("0")!!
            val btnTextClrSet = btnTextClr.toSet().toList()

            for (i in btnTextClrSet) {
                val linkBtn = findViewById<TextView>(i)
                linkBtn.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
            }


            Log.d(SAV, "Set ${btnTextClrSet}")

        }

    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        btnTextClr = savedInstanceState.getIntegerArrayList("0")!!

    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList("0", btnTextClr)

        super.onSaveInstanceState(outState)

    }


    fun buttonFilm1(view: View) {
        val intent = Intent(this@MainActivity, Film1::class.java)
        startActivity(intent)
        button.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        btnTextClr.add(button.id)
        Log.d(SAV, "btn ${btnTextClr[0]}")

    }

    fun buttonFilm2(view: View) {
        val intent = Intent(this@MainActivity, Film2::class.java)
        startActivity(intent)
        button2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        btnTextClr.add(button2.id)
    }

    fun buttonFilm3(view: View) {
        val intent = Intent(this@MainActivity, Film3::class.java)
        startActivity(intent)
        button3.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        btnTextClr.add(button3.id)
    }

    fun buttonFilm4(view: View) {
        val intent = Intent(this@MainActivity, Film4::class.java)
        startActivity(intent)
        button4.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
        btnTextClr.add(button4.id)
    }

    override fun onBackPressed() {
       // super.onBackPressed()
        showAlertDialog()


    }
   private fun showAlertDialog() {
        val bld: AlertDialog.Builder = AlertDialog.Builder(this)
        val lst = DialogInterface.OnClickListener { dialog, which -> finish() }
       // bld.setMessage("Really exit?")
        bld.setTitle("Really exit?")
        bld.setNegativeButton("No", lst)
        // bld.setNeutralButton("Later", lst)
        bld.setPositiveButton("Agree :(", lst)
        val dialog: AlertDialog = bld.create()
        dialog.show()
    }
}

