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
import kotlinx.android.synthetic.main.fragment_manga_list.view.*
import java.lang.Exception

class MangaListFragment(private val listener: MangaListFragmentListener? = null) : Fragment(),
    MangaAdapterListener {
    private lateinit var adapter: MangaAdapter

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
        } catch (e: Exception) {
        }

        listener?.onBookSelected(manga)
    }
}