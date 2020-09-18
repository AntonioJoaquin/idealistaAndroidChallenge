package com.idealista.android.challenge.list.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ActivityAdsBinding

class AdsActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this@AdsActivity, ViewModelFactory()).get(AdsViewModel::class.java)
    }
    private val binding: ActivityAdsBinding by lazy {
        DataBindingUtil.setContentView<ActivityAdsBinding>(this@AdsActivity, R.layout.activity_ads).apply {
            this.lifecycleOwner = this@AdsActivity
            this.viewModel = this@AdsActivity.viewModel
        }
    }

    private lateinit var adPath: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         adPath = intent.getStringExtra("URL") ?: ""

        init()
    }


    private fun init() {
        binding.textViewAdTitle.text = ""
        viewModel.getAdDetails(adPath)
    }
}