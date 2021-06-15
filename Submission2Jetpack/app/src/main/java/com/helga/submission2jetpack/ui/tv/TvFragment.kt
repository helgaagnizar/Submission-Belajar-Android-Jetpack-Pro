package com.helga.submission2jetpack.ui.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import com.helga.submission2jetpack.R
import com.helga.submission2jetpack.data.TvshowEntity
import com.helga.submission2jetpack.databinding.FragmentTvBinding
import com.helga.submission2jetpack.viewmodel.ViewModelFactory

class TvFragment : Fragment(), TvFragmentCallback {

    private lateinit var fragmentTvBinding: FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvViewModel::class.java]
            val tvs = viewModel.getTv()
            val tvAdapter = TvAdapter(this)

            fragmentTvBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTv().observe(viewLifecycleOwner, { tvshows ->
                fragmentTvBinding.progressBar.visibility = View.GONE
                tvAdapter.setTv(tvshows)
                tvAdapter.notifyDataSetChanged()
            })
            with(fragmentTvBinding.rvTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }

    override fun onShareClick(tv: TvshowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan tv show ini sekarang")
                .setText(resources.getString(R.string.share_text, tv.title))
                .startChooser()
        }
    }
}