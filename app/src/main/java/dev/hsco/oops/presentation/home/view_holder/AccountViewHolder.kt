package dev.hsco.oops.presentation.home.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hsco.oops.databinding.HolderHomeAccountBinding

class AccountViewHolder(
    binding: HolderHomeAccountBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): AccountViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HolderHomeAccountBinding.inflate(layoutInflater, parent, false)
            return AccountViewHolder(binding)
        }
    }
}