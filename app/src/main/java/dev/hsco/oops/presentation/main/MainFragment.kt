package dev.hsco.oops.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dev.hsco.oops.databinding.FragmentMainBinding
import dev.hsco.oops.databinding.FragmentMainBindingImpl
import dev.hsco.oops.presentation.util.custom_view.FixedTabLayoutMediator


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBindingImpl.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        bindViewModel()
    }

    private fun initView() {
        val mainPagerAdapter = MainPagerAdapter(this)
        binding.viewPager.adapter = mainPagerAdapter
        FixedTabLayoutMediator(binding.viewPager, binding.tabLayout).attach()
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}