package ru.s.ottusapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.R
import ru.s.ottusapp.filmsRecycler.FilmAdapter
import ru.s.ottusapp.filmsRecycler.Films.listFilms

class FilmListFragment:Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_news_list, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		view.findViewById<RecyclerView>(R.id.recyclerView_fragment).adapter = FilmAdapter(LayoutInflater.from(context), listFilms)
	}
}