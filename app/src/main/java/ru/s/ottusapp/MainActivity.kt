package ru.s.ottusapp


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.s.ottusapp.filmsRecycler.*
import ru.s.ottusapp.filmsRecycler.Films.listFavorite
import ru.s.ottusapp.filmsRecycler.Films.listFilms
import ru.s.ottusapp.fragment.FavoriteFragment
import ru.s.ottusapp.fragment.FilmListFragment
import ru.s.ottusapp.fragment.FilmsDetailedFragment


class MainActivity : AppCompatActivity(),
    FilmListFragment.OnFilmsClickListener,
    FavoriteFragment.OnFavoriteClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, FilmListFragment(), FilmListFragment.TAG)
            .commit()
    }

	override fun onAttachFragment(fragment: Fragment?) {
		super.onAttachFragment(fragment)

        when (fragment) {
            is FilmListFragment -> fragment.listener = this
            is FavoriteFragment -> fragment.listener = this
        }
	}


    private fun openFilmsDetailed(item: FilmsItem){
	    Toast.makeText(this, item.title, Toast.LENGTH_LONG ).show()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, FilmsDetailedFragment(), FilmsDetailedFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    fun favoriteFilms(view: View) {
        listFavorite = listFilms.filter { i:FilmsItem -> i.favor }.toMutableList()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, FavoriteFragment(), FavoriteFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    override fun onFilmClick(item: FilmsItem) {
        openFilmsDetailed(item)
        Log.e("Click","FilmClick")
    }

    override fun onFavoriteClick(item: FilmsItem) {
        openFilmsDetailed(item)
        Log.e("Click","FavClick")
    }
}

