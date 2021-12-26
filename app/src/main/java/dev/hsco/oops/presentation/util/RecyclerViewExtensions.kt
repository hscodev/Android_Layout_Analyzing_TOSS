package dev.hsco.oops.presentation.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("setData")
fun <DATA> RecyclerView.setData(dataList: List<DATA>?) {
    dataList?.also {
        @Suppress("UNCHECKED_CAST")
        (adapter as? ListAdapter<DATA, *>)?.submitList(it)
    }
}