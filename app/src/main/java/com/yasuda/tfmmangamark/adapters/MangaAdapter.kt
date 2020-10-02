package com.yasuda.tfmmangamark.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yasuda.tfmmangamark.R
import com.yasuda.tfmmangamark.model.Manga
import com.yasuda.tfmmangamark.model.User
import com.yasuda.tfmmangamark.util.MangaServiceGenerator
import kotlinx.android.synthetic.main.item_manga.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MangaAdapter(
                private val listener: MangaAdapterListener,
                ) :
    RecyclerView.Adapter<MangaAdapter.ViewHolder>() {

    private var mangas = mutableListOf<Manga>()
    private val service = MangaServiceGenerator.getService()

    init {
        service.getAll().enqueue(object : Callback<List<Manga>> {
            override fun onFailure(call: Call<List<Manga>>, t: Throwable) {}

            override fun onResponse(call: Call<List<Manga>>, response: Response<List<Manga>>) {
                mangas = response.body()!!.toMutableList()
                notifyDataSetChanged()
            }
        })
    }


    override fun getItemViewType(position: Int) = R.layout.item_manga

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(viewType, parent, false)
        )

    override fun getItemCount() = mangas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = mangas[position]
        holder.fillView(book)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(manga: Manga) {
            Picasso.get().load(manga.cover).into(itemView.img_cover_default);
            itemView.txt_lbManga_Title.text = manga.title
            itemView.txt_lbManga_Author.text = manga.author
            itemView.txt_n_capt.text = manga.edition.toString()

            itemView.setOnClickListener {
                listener.onBookSelected(manga)
            }

            itemView.add_my_list?.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    println("add to bookmark")
                }
                else{
                    println("else")
                }
            }
        }
    }
}