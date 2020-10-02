package com.yasuda.tfmmangamark.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yasuda.tfmmangamark.R
import com.yasuda.tfmmangamark.adapters.MangaAdapter
import com.yasuda.tfmmangamark.adapters.MangaAdapterListener
import com.yasuda.tfmmangamark.model.Manga
import com.yasuda.tfmmangamark.model.User
import com.yasuda.tfmmangamark.util.MangaServiceGenerator
import kotlinx.android.synthetic.main.fragment_manga_list.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MangaListFragment() : Fragment(),
    MangaAdapterListener {
    private lateinit var adapter: MangaAdapter
    private val service = MangaServiceGenerator.getService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_manga_list, container, false)

        adapter = MangaAdapter(this)
        view.listBooks.adapter = adapter
        view.listBooks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)

        return view
    }

    override fun onBookSelected(manga: Manga) {
        val bundle = Bundle()
        bundle.putSerializable("book", manga)
        try {
            findNavController().navigate(R.id.navigateToBookFragment, bundle)
        } catch (e: Exception) { }
    }

    override fun userInsert(user: User) {
        service.insertUser(user)
            .enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {}
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    user.id = response.body()!!.id
                }
            })
    }

    override fun userUpdate(user: User) {
        service.updateUser(user.id.toLong(), user).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {}
            override fun onResponse(call: Call<User>, response: Response<User>) {}
        })
    }

}