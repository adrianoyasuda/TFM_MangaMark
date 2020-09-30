package com.yasuda.tfmmangamark.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yasuda.tfmmangamark.R
import com.yasuda.tfmmangamark.model.Manga
import com.yasuda.tfmmangamark.model.Chapter
import kotlinx.android.synthetic.main.item_chapter.view.*

class ChapterAdapter(val manga: Manga) : RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {
    private val chapters
        get() = manga.chapters

    override fun getItemViewType(position: Int) = R.layout.item_chapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(viewType, parent, false)
        )

    override fun getItemCount() = chapters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.fillView(chapter)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(chapter: Chapter) {
            itemView.lbChapterTitle.text = chapter.title
        }
    }
}