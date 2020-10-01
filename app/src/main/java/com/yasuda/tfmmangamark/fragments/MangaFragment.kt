package com.yasuda.tfmmangamark.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yasuda.tfmmangamark.R
import com.yasuda.tfmmangamark.adapters.ChapterAdapter
import com.yasuda.tfmmangamark.model.Manga
import com.yasuda.tfmmangamark.results.GetChaptersResult
import com.yasuda.tfmmangamark.util.MangaServiceGenerator
import kotlinx.android.synthetic.main.fragment_manga.view.*
import kotlinx.android.synthetic.main.fragment_manga.view.txt_lbManga_Author
import kotlinx.android.synthetic.main.fragment_manga.view.txt_lbManga_Title
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MangaFragment : Fragment() {
    private lateinit var manga: Manga

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_manga, container, false)

        manga = arguments?.getSerializable("book") as Manga

        Picasso.get().load(manga.cover).into(view.img_cover);
        view.txt_lbManga_Title.text = manga.title
        view.txt_lbManga_Author.text = manga.author
        view.txt_lbManga_Edition.text = manga.edition.toString()
        view.txt_lbManga_Year.text = manga.year.toString()
        view.txt_lbManga_Publisher.text = manga.publisher

        loadChapters()

        return view
    }

    private fun loadChapters() {
        val service = MangaServiceGenerator.getService()
        service.getChapters(manga.id).enqueue(object : Callback<GetChaptersResult> {
            override fun onFailure(call: Call<GetChaptersResult>, t: Throwable) {}

            override fun onResponse(
                call: Call<GetChaptersResult>,
                response: Response<GetChaptersResult>
            ) {
                manga.chapters = response.body()!!.chapters
                showChapters()
            }
        })
    }

    private fun showChapters() {
        val adapter = ChapterAdapter(manga)
        val view = view as View
        view.listChapters.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        view.listChapters.adapter = adapter
    }
}