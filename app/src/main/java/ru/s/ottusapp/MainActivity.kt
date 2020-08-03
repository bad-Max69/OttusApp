package ru.s.ottusapp


import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.View
import android.widget.ImageView
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

        openListFilmsFragment()

    }

    private fun openListFilmsFragment() =  supportFragmentManager
        .beginTransaction()
        .replace(R.id.fragmentContainer, FilmListFragment(), FilmListFragment.TAG)
        .commit()


    fun openFavoriteFilmsFragment(view: View) {
        listFavorite = listFilms.filter { i:FilmsItem -> i.favor }.toMutableList() //проблема выбора itema в фаворитах

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, FavoriteFragment(), FavoriteFragment.TAG)
            .addToBackStack(null)
            .commit()
    }



    private fun openFilmsDetailedFragment(item: FilmsItem, sharedTitle: View, sharedSubTitle: View){

        //sharedTitle.transitionName = "123"
        val detailedFragment = FilmsDetailedFragment.newInstance(item).apply {

            sharedElementEnterTransition = TransitionInflater.from(this@MainActivity)
                .inflateTransition(R.transition.simple_transition)
        }

        supportFragmentManager
            .beginTransaction()
            .addSharedElement(sharedTitle, "sharedTitle")
            .addSharedElement(sharedSubTitle, "sharedImageView")
            .replace(R.id.fragmentContainer,detailedFragment , FilmsDetailedFragment.TAG)
            .addToBackStack(null)
            .commit()
    }



    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)

        when (fragment) {
            is FilmListFragment -> {fragment.listener = this; Log.e("fragmentList","now")}
            is FavoriteFragment -> {fragment.listenerFav = this;  Log.e("fragmentFavor","now")}
            is FilmsDetailedFragment -> {  Log.e("fragmentDetal","now")}
        }
    }



    override fun onFilmClick(item: FilmsItem, sharedTitle: View, sharedImageView: ImageView) {
        openFilmsDetailedFragment(item, sharedTitle, sharedImageView)
        Log.e("Click","FilmClick")
    }

    override fun onFavoriteClick(item: FilmsItem, sharedTitle: View, sharedImageView: ImageView) {
        openFilmsDetailedFragment(item, sharedTitle, sharedImageView)
        Log.e("Click","FavClick")
    }
}

