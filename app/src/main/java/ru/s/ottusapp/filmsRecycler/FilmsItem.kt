package ru.s.ottusapp.filmsRecycler

import java.io.Serializable

data class FilmsItem(val title:Int, val Subtitle: Int, val drawable: Int, var favor: Boolean = false):Serializable

