package com.yasuda.tfmmangamark

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yasuda.tfmmangamark.db.AppDatabase
import com.yasuda.tfmmangamark.db.dao.UserDao
import kotlinx.android.synthetic.main.activity_main.*


class ListActivity : AppCompatActivity() {

    lateinit var userDao: UserDao

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.nav_item_list -> {
                finish()
                startActivity(getIntent())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_item_bookmark -> {

                val intent = Intent(this, BookmarkActivity::class.java)
                val id = intent.getSerializableExtra("id")
                intent.putExtra("id", id)
                startActivity(intent)

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_item_logout -> {
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

        val db =
            Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "tb_user.db"
            )
                .allowMainThreadQueries()
                .build()
        userDao = db.userDao()

        @Suppress("UNSAFE_CALL_ON_PARTIALLY_DEFINED_RESOURCE")
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


}