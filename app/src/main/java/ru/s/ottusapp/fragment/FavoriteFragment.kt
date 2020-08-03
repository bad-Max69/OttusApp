package ru.s.ottusapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_films_favorite.view.*
import ru.s.ottusapp.R
import ru.s.ottusapp.filmsRecycler.FilmAdapter
import ru.s.ottusapp.filmsRecycler.Films
import ru.s.ottusapp.filmsRecycler.FilmsItem

class FavoriteFragment : Fragment() {

	var listenerFav: OnFavoriteClickListener? = null

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

		view.recyclerView_fragment_favorite.adapter =
			FilmAdapter(
				LayoutInflater.from(context),
				Films.listFavorite
			) {item, sharedTitle, sharedImageView:ImageView -> listenerFav?.onFavoriteClick(item, sharedTitle, sharedImageView) }

		Log.e(TAG,"Created")
	}

	/*override fun onResume() {
		super.onResume()
		Log.e(TAG, "Resume")
	}

	override fun onPause() {
		super.onPause()

		Log.e(TAG, "Pause")
	}

	override fun onStop() {
		super.onStop()

		Log.e(TAG, "Stop")
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.e(TAG, "Destroy")

	}

	override fun onDetach() {
		super.onDetach()
		Log.e(TAG, "Detach")

	}*/

	companion object {
		const val TAG = "FavoriteListFragment"
	}


	interface OnFavoriteClickListener {
		fun onFavoriteClick(item: FilmsItem, sharedTitle: View, sharedImageView: ImageView)
	}
}

