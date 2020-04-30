package ru.s.ottusapp.filmsActivity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.R

class NewsViewHolder (item:View): RecyclerView.ViewHolder(item) {
	val title:TextView = item.findViewById(R.id.title)
	val subtitle:TextView = item.findViewById(R.id.sub_title)
	val image: ImageView = item.findViewById(R.id.image)

	fun bind (item: FilmsItem){
		title.setText(item.title)               // title.text = item.title
		subtitle.setText(item.Subtitle)         // subtitle.text = item.subtitle
		image.setImageResource(item.drawable)   // image.setImageResource(item.drawable)
	}
}