package ru.s.ottusapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.R
import ru.s.ottusapp.filmsRecycler.FilmAdapter
import ru.s.ottusapp.filmsRecycler.Films.listFilms
import ru.s.ottusapp.filmsRecycler.FilmsItem

class FilmListFragment:Fragment() {

	var listener: OnFilmsClickListener? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		retainInstance = true
	}


	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_films_list, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		view.findViewById<RecyclerView>(R.id.recyclerView_fragment).adapter =
			FilmAdapter(LayoutInflater.from(context),
			listFilms
		)  {item, sharedTitle, sharedSubTitle-> listener?.onFilmClick(item, sharedTitle, sharedSubTitle)}

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


	interface OnFilmsClickListener {
		fun onFilmClick(item: FilmsItem, sharedTitle: View, sharedImageView: ImageView)

	}

	companion object {
		const val TAG = "FilmsListFragment"

		}
}