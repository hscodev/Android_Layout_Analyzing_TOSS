package dev.hsco.oops.presentation.util.layout_manager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchLinearLayoutManager @JvmOverloads constructor(
    context: Context,
    orientation: Int = RecyclerView.VERTICAL,
    reverseLayout: Boolean = false
) : LinearLayoutManager(context, orientation, reverseLayout) {

    fun isCompletelyVisible(targetPosition: Int, bottomPosition: Int, stickyItemHeight: Int): Boolean {
        val itemPosition = findLastVisibleItemPosition()
        return when {
            itemPosition > targetPosition -> true
            itemPosition < targetPosition -> false
            else -> getChildAt(itemPosition)?.let {
                val targetLocation = IntArray(2)
                it.getLocationInWindow(targetLocation)
                targetLocation[1] < bottomPosition - stickyItemHeight
            } ?: false
        }
    }

}