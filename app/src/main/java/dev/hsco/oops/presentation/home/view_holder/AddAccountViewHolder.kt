package dev.hsco.oops.presentation.home.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hsco.oops.databinding.HolderHomeAddAccountBinding

class AddAccountViewHolder(
    binding: HolderHomeAddAccountBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): AddAccountViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HolderHomeAddAccountBinding.inflate(layoutInflater, parent, false)
            return AddAccountViewHolder(binding)
        }
    }
}