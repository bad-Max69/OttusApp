package ru.s.ottusapp.filmsRecycler

import ru.s.ottusapp.R

object Films {

	val listFilms = mutableListOf(
		FilmsItem (R.string.Film1, R.string.detailsFilm1, R.drawable.invasionimg ),
		FilmsItem (R.string.Film2, R.string.detailsFilm2, R.drawable.venomimg),
		FilmsItem (R.string.Film3, R.string.detailsFilm3, R.drawable.androidimg ),
		FilmsItem (R.string.Film1, R.string.detailsFilm1, R.drawable.invasionimg),
		FilmsItem (R.string.Film2, R.string.detailsFilm2, R.drawable.venomimg),
		FilmsItem (R.string.Film3, R.string.detailsFilm3, R.drawable.androidimg),
		FilmsItem (R.string.Film1, R.string.detailsFilm1, R.drawable.invasionimg ),
		FilmsItem (R.string.Film2, R.string.detailsFilm2, R.drawable.venomimg ),
		FilmsItem (R.string.Film3, R.string.detailsFilm3, R.drawable.androidimg ),
		FilmsItem (R.string.Film4, R.string.detailsFilm4, R.drawable.avengerswarimg )
	)

	var listFavorite = mutableListOf<FilmsItem>()
}