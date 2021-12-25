package dev.hsco.oops.presentation.home.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hsco.oops.databinding.HolderHomeAccountBookBinding

class AccountBookViewHolder(
    binding: HolderHomeAccountBookBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): AccountBookViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HolderHomeAccountBookBinding.inflate(layoutInflater, parent, false)
            return AccountBookViewHolder(binding)
        }
    }
}