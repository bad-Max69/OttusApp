package ru.s.ottusapp.filmsRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_films.view.*
import ru.s.ottusapp.R
import ru.s.ottusapp.filmsRecycler.Films.listFilms

class FilmAdapter(private var inflater: LayoutInflater,
                  private var items: List<FilmsItem>,
                  private var listener: ((filmsItem: FilmsItem, sharedTitle: View, sharedImageView: ImageView) -> Unit)?): RecyclerView.Adapter<FilmsViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
		return FilmsViewHolder(inflater.inflate(R.layout.item_films, parent, false))
	}

	override fun getItemCount(): Int = items.size

	override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
		holder.bind(items[position])
		holder.wish.setOnCheckedChangeListener(null)
		holder.wish.isChecked = items[position].favor
		holder.wish.setOnCheckedChangeListener {
				_,
				isChecked -> items[position].favor = isChecked
		}
		holder.itemView.setOnClickListener{

			listener?.invoke(listFilms[position], holder.itemView.title, holder.itemView.image)
		}


	}

}