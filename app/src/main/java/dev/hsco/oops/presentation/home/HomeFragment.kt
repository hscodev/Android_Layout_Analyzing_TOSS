package dev.hsco.oops.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import dev.hsco.oops.databinding.FragmentHomeBinding
import dev.hsco.oops.presentation.util.SearchLinearLayoutManager

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        bindViewModel()
        viewModel.load()
    }

    private fun initView() {
        val layoutManager = SearchLinearLayoutManager(requireContext())
        val adapter = HomeAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val targetPosition = adapter.getPosition(HomeDataItem.ViewType.ACCOUNT_BOOK)
                if (targetPosition != -1) {
                    val position = IntArray(2)
                    binding.recyclerView.getLocationInWindow(position)
                    val bottomPosition = binding.recyclerView.height + position[1]
                    val stickyItemHeight = binding.bottomAccountBookBg.height
                    viewModel.onStickyVisible(
                        layoutManager.isCompletelyVisible(targetPosition, bottomPosition, stickyItemHeight)
                    )
                } else {
                    viewModel.onStickyVisible(false)
                }
            }
        })
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}