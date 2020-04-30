package ru.s.ottusapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.filmsActivity.*
import ru.s.ottusapp.filmsActivity.Films.listFilms

class MainActivity : AppCompatActivity() {






    val test = "sdfafdMSX"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        initRecycler()
    }

    fun initRecycler() {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = NewsAdapter(LayoutInflater.from(this), listFilms)
    }

    fun favoriteFilms(view: View) {


           val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
          // intent.putExtra("favorite_list", favoriteList as Serializable)

           startActivity(intent)


            /*button2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
            btnTextClr.add(button2.id)*/
        }



}

