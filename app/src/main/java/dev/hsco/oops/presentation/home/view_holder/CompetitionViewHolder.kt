package dev.hsco.oops.presentation.home.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hsco.oops.databinding.HolderHomeCompetitionBinding

class CompetitionViewHolder(
    binding: HolderHomeCompetitionBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup): CompetitionViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HolderHomeCompetitionBinding.inflate(layoutInflater, parent, false)
            return CompetitionViewHolder(binding)
        }
    }
}