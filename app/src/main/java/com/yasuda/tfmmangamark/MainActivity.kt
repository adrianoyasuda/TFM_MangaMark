package com.yasuda.tfmmangamark

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yasuda.tfmmangamark.fragments.MangaFragment
import com.yasuda.tfmmangamark.fragments.MangaListFragment
import com.yasuda.tfmmangamark.fragments.MangaListFragmentListener
import com.yasuda.tfmmangamark.model.Manga
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("UNSAFE_CALL_ON_PARTIALLY_DEFINED_RESOURCE")
class MainActivity : AppCompatActivity(), MangaListFragmentListener {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.nav_item_list ->  {
                switchFragment(MangaListFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_item_bookmark ->  {
                switchFragment(MangaListFragment())

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_item_logout ->  {
                switchFragment(MangaListFragment())
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val user_id = intent.getSerializableExtra("id")

//        if (complexLayout) {
//            supportFragmentManager.beginTransaction().apply {
//                val bookListFragment = MangaListFragment(this@MainActivity)
//                replace(R.id.mangaListFragmentContainer, bookListFragment)
//                commit()
//            }
//        }
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private fun switchFragment(fragment: Fragment){
        val fragmentTransation = supportFragmentManager.beginTransaction()
        fragmentTransation.replace(R.id.fragmentContainer, fragment)
        fragmentTransation.commit()
    }

    override fun onBookSelected(manga: Manga) {
switchFragment(MangaFragment())

        }

//    private val complexLayout
//        get() = mangaFragmentContainer != null
}