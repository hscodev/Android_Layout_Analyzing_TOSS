package dev.hsco.oops.presentation.home

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.hsco.oops.presentation.home.HomeDataItem.AccountBookDataItem
import dev.hsco.oops.presentation.home.view_holder.AccountBookViewHolder
import dev.hsco.oops.presentation.home.view_holder.AccountViewHolder
import dev.hsco.oops.presentation.home.view_holder.AddAccountViewHolder
import dev.hsco.oops.presentation.home.view_holder.CompetitionViewHolder
import java.lang.RuntimeException

class HomeAdapter(
    private val lifecycleOwner: LifecycleOwner
): ListAdapter<HomeDataItem, RecyclerView.ViewHolder>(getDiffUtil()) {

    override fun getItemViewType(position: Int): Int {
        return currentList[position].viewType.ordinal
    }

    fun getPosition(viewType: HomeDataItem.ViewType): Int {
        return currentList.indexOfFirst { it.viewType == viewType }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            HomeDataItem.ViewType.COMPETITION.ordinal -> CompetitionViewHolder.from(parent)
            HomeDataItem.ViewType.ACCOUNT.ordinal -> AccountViewHolder.from(parent)
            HomeDataItem.ViewType.ACCOUNT_BOOK.ordinal -> AccountBookViewHolder.from(parent, lifecycleOwner)
            HomeDataItem.ViewType.ADD_ACCOUNT.ordinal -> AddAccountViewHolder.from(parent)
            else -> throw RuntimeException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AccountBookViewHolder -> (getItem(position) as? AccountBookDataItem)?.also { holder.bind(it.viewData) }
        }
    }

    companion object {
        private fun getDiffUtil() = object : DiffUtil.ItemCallback<HomeDataItem>() {
            override fun areItemsTheSame(oldItem: HomeDataItem, newItem: HomeDataItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: HomeDataItem, newItem: HomeDataItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}