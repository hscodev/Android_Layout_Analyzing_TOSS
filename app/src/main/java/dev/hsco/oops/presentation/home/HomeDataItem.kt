package dev.hsco.oops.presentation.home

sealed class HomeDataItem(
    val viewType: ViewType
) {

    class CompetitionDataItem : HomeDataItem(ViewType.COMPETITION)
    class AccountBookDataItem : HomeDataItem(ViewType.ACCOUNT_BOOK)
    class AccountDataItem : HomeDataItem(ViewType.ACCOUNT)
    class AddAccountDataItem : HomeDataItem(ViewType.ADD_ACCOUNT)

    enum class ViewType {
        ACCOUNT, ACCOUNT_BOOK, COMPETITION, ADD_ACCOUNT
    }
}