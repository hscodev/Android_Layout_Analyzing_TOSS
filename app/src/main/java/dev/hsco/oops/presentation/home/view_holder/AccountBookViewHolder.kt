package dev.hsco.oops.presentation.home.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import dev.hsco.oops.databinding.HolderHomeAccountBookBinding
import dev.hsco.oops.presentation.util.setValueIfNew

class AccountBookViewHolder(
    private val binding: HolderHomeAccountBookBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: AccountBookViewData) {
        binding.viewData = viewData
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup, lifecycleOwner: LifecycleOwner): AccountBookViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HolderHomeAccountBookBinding.inflate(layoutInflater, parent, false)
            binding.lifecycleOwner = lifecycleOwner
            return AccountBookViewHolder(binding)
        }
    }
}

class AccountBookViewData {
    private val _bgExpand = MutableLiveData<Boolean>()
    val bgExpand: LiveData<Boolean> = _bgExpand

    fun setBgExpand(expand: Boolean) {
        _bgExpand.setValueIfNew(expand)
    }
}