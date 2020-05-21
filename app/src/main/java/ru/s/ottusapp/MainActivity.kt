package ru.s.ottusapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.filmsRecycler.*
import ru.s.ottusapp.filmsRecycler.Films.listFavorite
import ru.s.ottusapp.filmsRecycler.Films.listFilms


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        initRecycler()
    }

     private fun initRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = FilmAdapter(LayoutInflater.from(this), listFilms)

    }

    fun favoriteFilms(view: View) {
        val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
        listFavorite = listFilms.filter { i:FilmsItem -> i.favor }.toMutableList()
        startActivity(intent)
    }
}

