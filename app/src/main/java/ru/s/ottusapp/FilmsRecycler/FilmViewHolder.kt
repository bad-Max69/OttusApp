package ru.s.ottusapp.FilmsRecycler

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.R

class FilmViewHolder (item:View): RecyclerView.ViewHolder(item) {
	val title:TextView = item.findViewById(R.id.title)
	val subtitle:TextView = item.findViewById(R.id.sub_title)
	val image: ImageView = item.findViewById(R.id.image)
	var wish: CheckBox = item.findViewById(R.id.wish_box)



	fun bind (item: FilmsItem){
		title.setText(item.title)
		subtitle.setText(item.Subtitle)
		image.setImageResource(item.drawable)

	}
}