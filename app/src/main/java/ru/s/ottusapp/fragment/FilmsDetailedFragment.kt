package ru.s.ottusapp.fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import ru.s.ottusapp.MainActivity
import ru.s.ottusapp.R
//import android.widget.Toolbar
import kotlinx.android.synthetic.main.item_films.*

class FilmsDetailedFragment: Fragment() {



	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {




		return inflater.inflate(R.layout.fragment_films_detailed, container, false)

	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
		activity!!.setActionBar(toolbar)



		view.findViewById<Toolbar>(R.id.toolbar).title = "sfsfsd"



		Log.e(TAG, "Det")
	}

	companion object {
		const val TAG = "FilmsDetailedFragment"
	}

}