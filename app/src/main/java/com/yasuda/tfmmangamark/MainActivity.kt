package com.yasuda.tfmmangamark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yasuda.tfmmangamark.fragments.MangaFragment
import com.yasuda.tfmmangamark.fragments.MangaListFragment
import com.yasuda.tfmmangamark.fragments.MangaListFragmentListener
import com.yasuda.tfmmangamark.model.Manga
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MangaListFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (complexLayout) {
            supportFragmentManager.beginTransaction().apply {
                val bookListFragment = MangaListFragment(this@MainActivity)
                replace(R.id.mangaListFragmentContainer, bookListFragment)
                commit()
            }
        }
    }

    override fun onBookSelected(manga: Manga) {
        if (complexLayout) {
            supportFragmentManager.beginTransaction().apply {
                val bookFragment = MangaFragment()
                val bundle = Bundle()
                bundle.putSerializable("book", manga)

                bookFragment.arguments = bundle
                replace(R.id.mangaFragmentContainer, bookFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    private val complexLayout
        get() = mangaFragmentContainer != null
}