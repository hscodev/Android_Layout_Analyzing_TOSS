package dev.hsco.oops.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import dev.hsco.oops.databinding.FragmentHomeBinding
import dev.hsco.oops.presentation.main.MainViewModel
import dev.hsco.oops.presentation.util.dp
import dev.hsco.oops.presentation.util.layout_manager.SearchLinearLayoutManager
import dev.hsco.oops.presentation.util.setVisibilityIf

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        bindViewModel()
        observeViewModel()
        viewModel.load()
    }

    private fun initView() {
        binding.recyclerView.apply {
            adapter = HomeAdapter(viewLifecycleOwner)
            layoutManager = SearchLinearLayoutManager(requireContext())
            addOnScrollListener(getStickyControlScrollListener())
        }
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
    }

    private fun observeViewModel() {
        viewModel.stickyVisible.observe(viewLifecycleOwner) { visible ->
            if (!visible) initBottomAccountBookBgMargin()
            binding.stickyContainer.setVisibilityIf(visible)
            mainViewModel.setBottomNavigationBgTransition(visible)
        }
    }

    private fun initBottomAccountBookBgMargin() {
        binding.bottomAccountBookBg.apply {
            layoutParams = (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
                marginStart = 16.dp
                marginEnd = 16.dp
            }
        }
    }

    private fun getStickyControlScrollListener() = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val adapter = (recyclerView.adapter as? HomeAdapter)
            val layoutManager = (recyclerView.layoutManager as? SearchLinearLayoutManager)
            if (adapter == null || layoutManager == null) return

            val targetPosition = adapter.getPosition(HomeDataItem.ViewType.ACCOUNT_BOOK)
            if (targetPosition == -1) {
                viewModel.onStickyVisible(true)
            } else {
                val position = IntArray(2)
                binding.recyclerView.getLocationInWindow(position)
                val bottomPosition = binding.recyclerView.height + position[1] - 55.dp
                val stickyItemHeight = binding.bottomAccountBookBg.height
                val stickyVisible = !layoutManager.isCompletelyVisible(targetPosition, bottomPosition, stickyItemHeight)
                viewModel.onStickyVisible(stickyVisible)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.stickyVisible.value?.also {
            mainViewModel.setBottomNavigationBgTransition(it)
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}