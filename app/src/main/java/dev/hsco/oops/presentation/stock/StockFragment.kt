package dev.hsco.oops.presentation.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.hsco.oops.R
import dev.hsco.oops.presentation.main.MainViewModel

class StockFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.setBottomNavigationBgTransition(false)
    }

    companion object {
        fun newInstance() = StockFragment()
    }
}