package com.helga.submission3jetpack.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.helga.submission3jetpack.R
import com.helga.submission3jetpack.data.source.local.entity.TvshowEntity
import com.helga.submission3jetpack.databinding.ActivityDetailTvshowBinding
import com.helga.submission3jetpack.viewmodel.ViewModelFactory
import com.helga.submission3jetpack.vo.Status

class DetailTvshowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV = "extra_tv"
    }

    private lateinit var binding: ActivityDetailTvshowBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Detail Tvshow"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)

        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_TV)
            if (dataId != null) {
                viewModel.setSelectedTvshow(dataId)
                viewModel.getTvshowById.observe(this, {  tvshow ->
                    when(tvshow.status){
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS ->
                            if (tvshow.data != null){
                                binding.progressBar.visibility = View.GONE
                                populateTvshow(tvshow.data)
                            }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.VISIBLE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
        }

    }

    private fun populateTvshow(tvshowEntity: TvshowEntity) {
        var status = tvshowEntity.favorite
        setFavorite(status)
        binding.textTitle.text = tvshowEntity.title
        binding.textYear.text = tvshowEntity.year.toString()
        binding.textGenre.text = tvshowEntity.genre
        binding.textCreator.text = tvshowEntity.creator
        binding.textOverview.text = tvshowEntity.overview

        Glide.with(this)
            .load(tvshowEntity.image)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(binding.imgPoster)

        binding.fabFavTvshow.setOnClickListener {
            status = !status
            setFavorite(status)
            viewModel.setFavorite()
        }
    }

    private fun setFavorite(state: Boolean){
        if (state){
            binding.fabFavTvshow.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_black
                )
            )
        } else {
            binding.fabFavTvshow.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_border_black
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}