package ru.s.ottusapp.filmsActivity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.R

class NewsViewHolder (item:View): RecyclerView.ViewHolder(item) {
	val titleNews:TextView = item.findViewById(R.id.title_news)
	val subtitleNews:TextView = item.findViewById(R.id.sub_title_news)
	val imageNews: ImageView = item.findViewById(R.id.image_news)

	fun bind (item: FilmsItem){
		titleNews.text = item.title
		subtitleNews.text = item.Subtitle
		imageNews.setBackgroundColor(item.color)
	}
}