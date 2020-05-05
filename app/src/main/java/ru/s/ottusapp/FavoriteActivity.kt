package ru.s.ottusapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.filmsActivity.Films.listFavorite
import ru.s.ottusapp.filmsActivity.FilmsItem

import ru.s.ottusapp.filmsActivity.FilmAdapter



class FavoriteActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_favorite)

		initRecycler(listFavorite)


	}


	fun initRecycler(list: MutableList<FilmsItem>) {
		val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
		val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

		recyclerView.layoutManager = layoutManager

		recyclerView.adapter = FilmAdapter(LayoutInflater.from(this), list)



	}

}

