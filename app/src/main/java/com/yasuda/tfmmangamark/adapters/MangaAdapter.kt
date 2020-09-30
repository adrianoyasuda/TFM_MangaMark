package com.yasuda.tfmmangamark.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yasuda.tfmmangamark.R
import com.yasuda.tfmmangamark.model.Manga
import com.yasuda.tfmmangamark.util.BookServiceGenerator
import kotlinx.android.synthetic.main.item_manga.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MangaAdapter(private val listener: MangaAdapterListener) :
    RecyclerView.Adapter<MangaAdapter.ViewHolder>() {

    private var books = mutableListOf<Manga>()
    private val service = BookServiceGenerator.getService()

    init {
        service.getAll().enqueue(object : Callback<List<Manga>> {
            override fun onFailure(call: Call<List<Manga>>, t: Throwable) {}

            override fun onResponse(call: Call<List<Manga>>, response: Response<List<Manga>>) {
                books = response.body()!!.toMutableList()
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

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.fillView(book)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(manga: Manga) {
            itemView.lbBookItemTitle.text = manga.title
            itemView.lbBookItemAuthor.text = manga.author

            itemView.setOnClickListener {
                listener.onBookSelected(manga)
            }
        }
    }
}