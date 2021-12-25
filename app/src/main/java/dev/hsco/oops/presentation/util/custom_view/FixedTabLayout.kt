package dev.hsco.oops.presentation.util.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.R
import dev.hsco.oops.databinding.ItemMainBottomTabBinding

class FixedTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.tabStyle
) : LinearLayout(context, attrs, defStyleAttr) {

    private var adapter: RecyclerView.Adapter<*>? = null
    private var eventListener: EventListener? = null

    init {
        orientation = HORIZONTAL
    }

    fun setViewPager(viewPager: ViewPager2) {
        this.adapter = viewPager.adapter
        this.adapter?.registerAdapterDataObserver(adapterODataObserver)
        populateTabsFromPagerAdapter()
    }

    fun setOnClickListener(eventListener: EventListener){
        this.eventListener = eventListener
        for (index in 0 until childCount) {
            getChildAt(index).setOnClickListener {
                eventListener.onItemSelected(index)
            }
        }
    }

    private fun populateTabsFromPagerAdapter() {
        removeAllViews()
        adapter?.run {
            for (index in 0 until itemCount) {
                addView(index)
            }
        }
    }

    private fun addView(position: Int) {
        val binding = createViewBinding()
        val tabView = binding.root

        tabView.setOnClickListener {
            eventListener?.onItemSelected(position)
        }

        (adapter as? TabAdapter)?.getTabItem(position)?.also {
            binding.tabItem = it
        }

        addView(tabView)
    }

    private fun createViewBinding(): ItemMainBottomTabBinding {
        return ItemMainBottomTabBinding.inflate(LayoutInflater.from(context)).apply {
            root.layoutParams = LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT).apply {
                weight = 1f
            }
        }
    }

    fun setSelected(position: Int){
        for (index in 0 until childCount) {
            getChildAt(index).isSelected = position == index
        }
    }

    private val adapterODataObserver = object : AdapterDataObserver() {
        override fun onChanged() {
            populateTabsFromPagerAdapter()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            populateTabsFromPagerAdapter()
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            populateTabsFromPagerAdapter()
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            populateTabsFromPagerAdapter()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            populateTabsFromPagerAdapter()
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            populateTabsFromPagerAdapter()
        }
    }

    interface TabAdapter {
        fun getTabItem(position: Int): TabItem
    }

    interface EventListener {
        fun onItemSelected(position: Int)
    }

    data class TabItem(
        val menuTitle: String,
        @DrawableRes val menuIcon: Int
    )
}