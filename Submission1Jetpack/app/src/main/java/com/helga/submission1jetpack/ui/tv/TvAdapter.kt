package com.helga.submission1jetpack.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.helga.submission1jetpack.data.TvshowEntity
import com.helga.submission1jetpack.databinding.ItemsTvBinding

class TvAdapter(private val callback: TvFragmentCallback) :
    RecyclerView.Adapter<TvAdapter.FilmViewHolder>() {
    private val listTv = ArrayList<TvshowEntity>()

    fun setTv(tvs: List<TvshowEntity>?) {
        if (tvs == null) return
        this.listTv.clear()
        this.listTv.addAll(tvs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemsTvBinding =
            ItemsTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(itemsTvBinding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val tv = listTv[position]
        holder.bind(tv)
    }

    override fun getItemCount(): Int = listTv.size

    inner class FilmViewHolder(private val binding: ItemsTvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TvshowEntity) {
            with(binding) {
                tvItemTitle.text = tv.title
                tvItemYear.text = tv.year.toString()
                tvItemGenre.text = tv.genre
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvshowActivity::class.java)
                    intent.putExtra(DetailTvshowActivity.EXTRA_TV, tv.tvshowId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tv) }
                Glide.with(itemView.context)
                    .load(tv.image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}