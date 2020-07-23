package ru.s.ottusapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.R
import ru.s.ottusapp.filmsRecycler.FilmAdapter
import ru.s.ottusapp.filmsRecycler.Films
import ru.s.ottusapp.filmsRecycler.FilmsItem

class FavoriteFragment : Fragment() {

	var listener: OnFavoriteClickListener? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		retainInstance = true
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_films_favorite, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		view.findViewById<RecyclerView>(R.id.recyclerView_fragment_favorite).adapter =
			FilmAdapter(
				LayoutInflater.from(context),
				Films.listFavorite
			) { listener?.onFavoriteClick(it) }

		Log.e(TAG,"Fav")
	}

	companion object {
		const val TAG = "FavoriteListFragment"
	}


	interface OnFavoriteClickListener {
		fun onFavoriteClick(item: FilmsItem)
	}
}

