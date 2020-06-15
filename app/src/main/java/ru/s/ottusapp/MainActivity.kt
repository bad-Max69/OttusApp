package ru.s.ottusapp


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.s.ottusapp.filmsRecycler.*
import ru.s.ottusapp.filmsRecycler.Films.listFavorite
import ru.s.ottusapp.filmsRecycler.Films.listFilms
import ru.s.ottusapp.fragment.FilmListFragment
import ru.s.ottusapp.fragment.FilmsDetailedFragment


class MainActivity : AppCompatActivity(), FilmListFragment.OnFilmsClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val fragment = FilmListFragment()
        fragment.listener = this

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment, FilmListFragment.TAG)
            .commit()
    }




    fun openFilmsDetailed(item: FilmsItem){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, FilmsDetailedFragment(), FilmsDetailedFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    fun favoriteFilms(view: View) {
        val intent = Intent(this@MainActivity, FavoriteActivity::class.java)
        listFavorite = listFilms.filter { i:FilmsItem -> i.favor }.toMutableList()
        startActivity(intent)
    }

    override fun onFilmClick(item: FilmsItem) {
        openFilmsDetailed(item)
    }
}

