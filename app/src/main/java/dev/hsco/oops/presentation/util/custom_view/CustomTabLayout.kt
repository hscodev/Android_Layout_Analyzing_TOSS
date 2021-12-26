package dev.hsco.oops.presentation.util.custom_view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.view.children
import com.google.android.material.R
import com.google.android.material.tabs.TabLayout

class CustomTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.tabStyle
) : TabLayout(context, attrs, defStyleAttr) {

    private val tabLayoutPaddingStart: Int
    private val tabLayoutPaddingEnd: Int

    init {
        val typedArray = context.obtainStyledAttributes(attrs, dev.hsco.oops.R.styleable.CustomTabLayout)
        tabLayoutPaddingStart = typedArray.getDimensionPixelSize(dev.hsco.oops.R.styleable.CustomTabLayout_tabLayoutPaddingStart, 0)
        tabLayoutPaddingEnd = typedArray.getDimensionPixelSize(dev.hsco.oops.R.styleable.CustomTabLayout_tabLayoutPaddingEnd, 0)
        typedArray.recycle()
    }

    override fun addTab(tab: Tab, position: Int, setSelected: Boolean) {
        super.addTab(tab, position, setSelected)
        updateTabsMargin()
    }

    private fun updateTabsMargin() {
        if (tabMode == MODE_FIXED && tabGravity == GRAVITY_FILL) {
            (getChildAt(0) as? LinearLayout)?.apply {
                children.forEachIndexed { index, view ->
                    val layoutParams = (view.layoutParams as? MarginLayoutParams)
                    if (index == 0 && tabLayoutPaddingStart != 0) {
                        layoutParams?.marginStart = tabLayoutPaddingStart
                    } else if (index + 1 == childCount && tabLayoutPaddingEnd != 0) {
                        layoutParams?.marginEnd = tabLayoutPaddingEnd
                    } else {
                        layoutParams?.marginStart = 0
                        layoutParams?.marginEnd = 0
                    }
                    layoutParams?.also { view.layoutParams = it }
                }
            }
        }
    }
}