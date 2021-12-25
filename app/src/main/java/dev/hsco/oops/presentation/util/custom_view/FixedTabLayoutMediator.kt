package dev.hsco.oops.presentation.util.custom_view

import androidx.viewpager2.widget.ViewPager2

class FixedTabLayoutMediator(
    private val viewPager: ViewPager2,
    private val tabLayout: FixedTabLayout
) {

    fun attach() {
        viewPager.registerOnPageChangeCallback(onPageChangedCallback)
        tabLayout.setViewPager(viewPager)
        tabLayout.setOnClickListener(onTabClickListener)
    }

    private val onPageChangedCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            tabLayout.setSelected(position)
        }
    }

    private val onTabClickListener = object : FixedTabLayout.EventListener {
        override fun onItemSelected(position: Int) {
            viewPager.setCurrentItem(position, false)
        }
    }

}