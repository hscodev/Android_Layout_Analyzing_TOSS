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
import dev.hsco.oops.presentation.util.custom_view.FixedTabLayout

class MainPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment),
    FixedTabLayout.TabAdapter {

    override fun getItemCount(): Int {
        return Items.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return Items.values()[position].fragment
    }

    override fun getTabItem(position: Int): FixedTabLayout.TabItem {
        return Items.values()[position].let {
            FixedTabLayout.TabItem(it.menuTitle, it.menuIcon)
        }
    }

    enum class Items(
        val fragment: Fragment,
        val menuTitle: String,
        @DrawableRes val menuIcon: Int
    ) {
        HOME(HomeFragment(), "홈", R.drawable.baseline_home_24),
        BENEFIT(BenefitFragment(), "혜택", R.drawable.outline_yard_24),
        REMITTANCE(RemittanceFragment(), "송금", R.drawable.baseline_local_atm_24),
        STOCK(StockFragment(), "주식", R.drawable.baseline_show_chart_24),
        FULL_MENU(FullMenuFragment(), "전체", R.drawable.baseline_menu_24)
    }
}