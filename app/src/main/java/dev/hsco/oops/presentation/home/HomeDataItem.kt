package dev.hsco.oops.presentation.home

import dev.hsco.oops.presentation.home.view_holder.AccountBookViewData

sealed class HomeDataItem(
    val viewType: ViewType
) {

    class CompetitionDataItem : HomeDataItem(ViewType.COMPETITION)
    data class AccountBookDataItem(val viewData: AccountBookViewData) : HomeDataItem(ViewType.ACCOUNT_BOOK)
    class AccountDataItem : HomeDataItem(ViewType.ACCOUNT)
    class AddAccountDataItem : HomeDataItem(ViewType.ADD_ACCOUNT)

    enum class ViewType {
        ACCOUNT, ACCOUNT_BOOK, COMPETITION, ADD_ACCOUNT
    }
}