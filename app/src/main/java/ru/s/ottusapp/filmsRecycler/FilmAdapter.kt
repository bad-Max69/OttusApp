package ru.s.ottusapp.filmsRecycler

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.R
import ru.s.ottusapp.filmsRecycler.Films.listFilms

class FilmAdapter(private var inflater: LayoutInflater,
                  private var items: List<FilmsItem>,
                  private var listener: ((filmsItem: FilmsItem) -> Unit)?): RecyclerView.Adapter<FilmViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
		return FilmViewHolder(inflater.inflate(R.layout.item_films, parent, false))
	}

	override fun getItemCount(): Int = items.size

	override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
		holder.bind(items[position])
		holder.wish.setOnCheckedChangeListener(null)
		holder.wish.isChecked = items[position].favor
		holder.wish.setOnCheckedChangeListener {
				_,
				isChecked -> items[position].favor = isChecked
		}
		holder.itemView.setOnClickListener{
			listener?.invoke(listFilms[position])
		}


	}

}