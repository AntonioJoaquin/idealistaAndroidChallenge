package com.idealista.android.challenge.list.ui.ads.multimedias

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.idealista.android.challenge.list.R
import com.idealista.android.challenge.list.databinding.ViewImageItemBinding

class ImageSliderAdapter: PagerAdapter() {

    var items = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun isViewFromObject(view: View, `object`: Any): Boolean =
        view === `object`

    override fun getCount(): Int =
        items.size


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = DataBindingUtil.inflate<ViewImageItemBinding>(
            LayoutInflater.from(container.context),
            R.layout.view_image_item,
            container,
            false
        )

        binding.path = items[position]
        binding.executePendingBindings()

        val viewPager = container as ViewPager
        viewPager.addView(binding.root, 0)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View

        viewPager.removeView(view)
    }

}