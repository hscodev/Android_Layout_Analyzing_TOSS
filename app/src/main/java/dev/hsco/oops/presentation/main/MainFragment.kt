package dev.hsco.oops.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dev.hsco.oops.databinding.FragmentMainBinding
import dev.hsco.oops.databinding.FragmentMainBindingImpl
import dev.hsco.oops.databinding.ItemMainBottomTabBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBindingImpl.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val mainPagerAdapter = MainPagerAdapter(this)
        binding.viewPager.adapter = mainPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.customView = createTabView(mainPagerAdapter.getTabItem(position))
        }.attach()
    }

    private fun createTabView(tabItem : MainPagerAdapter.Items): View{
        return ItemMainBottomTabBinding.inflate(layoutInflater).apply {
            this.tabItem = tabItem
        }.root
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}