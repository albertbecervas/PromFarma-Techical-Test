package com.abecerra.technicaltestpromofarma.presentation.ui.repos

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.abecerra.technicaltestpromofarma.R
import com.abecerra.technicaltestpromofarma.app.base.BaseAdapter
import com.abecerra.technicaltestpromofarma.app.utils.extensions.inflate
import com.abecerra.technicaltestpromofarma.presentation.data.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class ReposAdapter(private val onSelected: (repo: Repo) -> Unit) : BaseAdapter<ReposAdapter.ReposViewHolder, Repo>() {
    override fun onBindViewHolder(holder: ReposViewHolder, item: Repo, position: Int) {
        with(holder) {
            name.text = item.name
            description.text = item.description
            language.text = item.language
            stars.text = item.stars.toString()
            elapsedTime.text = item.timeSinceLastUpdate
            layout.setOnClickListener {
                onSelected.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ReposViewHolder =
        ReposViewHolder(inflate(R.layout.item_repo, p0))

    class ReposViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layout: ConstraintLayout = view.layout
        val name: TextView = view.tvName
        val description: TextView = view.tvDescription
        val language: TextView = view.tvLanguage
        val stars: TextView = view.tvStars
        val elapsedTime: TextView = view.tvElapsedTime
    }

}