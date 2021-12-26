package dev.hsco.oops.presentation.main

import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.hsco.oops.R
import dev.hsco.oops.presentation.benefit.BenefitFragment
import dev.hsco.oops.presentation.full_menu.FullMenuFragment
import dev.hsco.oops.presentation.home.HomeFragment
import dev.hsco.oops.presentation.remittance.RemittanceFragment
import dev.hsco.oops.presentation.stock.StockFragment

class MainPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return Items.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return when (Items.values()[position]) {
            Items.BENEFIT -> BenefitFragment()
            Items.HOME -> HomeFragment()
            Items.REMITTANCE -> RemittanceFragment()
            Items.STOCK -> StockFragment()
            Items.FULL_MENU -> FullMenuFragment()
        }
    }

    fun getTabItem(position: Int): Items {
        return Items.values()[position]
    }

    enum class Items(
        val menuTitle: String,
        @DrawableRes val menuIcon: Int
    ) {
        HOME("홈", R.drawable.baseline_home_24),
        BENEFIT("혜택", R.drawable.outline_yard_24),
        REMITTANCE("송금", R.drawable.baseline_local_atm_24),
        STOCK("주식", R.drawable.baseline_show_chart_24),
        FULL_MENU("전체", R.drawable.baseline_menu_24)
    }
}