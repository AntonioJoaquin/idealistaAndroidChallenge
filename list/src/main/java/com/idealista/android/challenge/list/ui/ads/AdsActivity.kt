package com.idealista.android.challenge.list.ui.ads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ActivityAdsBinding
import com.idealista.android.challenge.list.ui.ViewModelFactory
import com.idealista.android.challenge.list.ui.ads.multimedias.ImageSliderAdapter

class AdsActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this@AdsActivity, ViewModelFactory()).get(AdsViewModel::class.java)
    }
    private val binding: ActivityAdsBinding by lazy {
        DataBindingUtil.setContentView<ActivityAdsBinding>(this@AdsActivity, R.layout.activity_ads).apply {
            this.lifecycleOwner = this@AdsActivity
            this.adapter = this@AdsActivity.adapter
            this.viewModel = this@AdsActivity.viewModel
        }
    }

    private val adapter = ImageSliderAdapter()

    private lateinit var adPath: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         adPath = intent.getStringExtra("URL") ?: ""

        init()
    }


    private fun init() {
        initView()

        viewModel.getAdDetails(adPath)
    }

    private fun initView() {
        binding.viewMultimedia.tabLayoutIndicator.setupWithViewPager(binding.viewMultimedia.viewPagerMultimedias)

        binding.textViewAdDescription.maxLines = DEFAULT_LINES_SPANNABLE_TEXT

        binding.textViewSeeAllDescription.clickForSpannableText(binding.textViewAdDescription)
    }

}