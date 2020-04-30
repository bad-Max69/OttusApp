package ru.s.ottusapp.filmsActivity

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.R

class NewsAdapter(var inflater: LayoutInflater, var items: List<FilmsItem>): RecyclerView.Adapter<NewsViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
		Log.d("NewsAdapter","onCreateViewHolder $viewType")
		return NewsViewHolder(inflater.inflate(R.layout.item_films, parent, false))


	}

	override fun getItemCount(): Int = items.size

	override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
		holder.bind(items[position])

		Log.d("NewsAdapter","onBindViewHolder $position" )

	}

}