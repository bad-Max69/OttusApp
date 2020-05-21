package ru.s.ottusapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_favorite.*
import ru.s.ottusapp.filmsRecycler.Films.listFavorite
import ru.s.ottusapp.filmsRecycler.FilmsItem

import ru.s.ottusapp.filmsRecycler.FilmAdapter



class FavoriteActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_favorite)

		initRecycler(listFavorite)

		addBtn.setOnClickListener{
			listFavorite.add(FilmsItem(R.string.Film4, R.string.detailsFilm4, R.color.btnColorLink) )
			recyclerView.adapter?.notifyItemInserted(1)
		}

		delBtn.setOnClickListener{
			if (listFavorite.size>2) listFavorite.removeAt(2)
			recyclerView.adapter?.notifyItemRemoved(1)
		}
	}

	 private fun initRecycler(list: MutableList<FilmsItem>) {
		val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
		val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
		recyclerView.layoutManager = layoutManager
		recyclerView.adapter = FilmAdapter(LayoutInflater.from(this), list)
	}
}

