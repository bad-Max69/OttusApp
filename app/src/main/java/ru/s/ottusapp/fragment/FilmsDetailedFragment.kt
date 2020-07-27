package ru.s.ottusapp.fragment

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_films_detailed.view.*
import kotlinx.android.synthetic.main.item_films.*
import ru.s.ottusapp.R
import ru.s.ottusapp.filmsRecycler.FilmsItem


class FilmsDetailedFragment(): Fragment() {



	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {


		return inflater.inflate(R.layout.fragment_films_detailed, container, false)

	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val item = arguments?.getSerializable("1")
		val title : String = getString((item as FilmsItem).title)
		val subTitle : String = getString((item as FilmsItem).Subtitle)

		view.toolbar.title = title
		view.description.text = subTitle
		view.imageFragmentFilmsDetailed.setImageResource((item as FilmsItem).drawable)
		//view.toolbar.title = arguments.getInt("1").toString()
			//	(view as TextView).toolbar = arguments?.getInt("1", 0)


		Log.e(TAG, "Created")
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
		const val TAG = "FilmsDetailedFragment"

		fun newInstance (item: FilmsItem ) : FilmsDetailedFragment {

			val fragment = FilmsDetailedFragment()
			val bundle = Bundle()


			bundle.putSerializable("1", item)
			fragment.arguments = bundle

			return fragment
		}
	}



}