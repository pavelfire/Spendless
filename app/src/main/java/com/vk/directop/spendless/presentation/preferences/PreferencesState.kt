package com.vk.directop.spendless.presentation.preferences

import android.icu.util.Currency

data class PreferencesState(
    val expensesFormat: String = "",
    val currency: String = "USD",
    val decimalSeparator: String = ",",
    val thousandsSeparator: ThousandsSeparator = ThousandsSeparator.SPACE
) {
    enum class ThousandsSeparator(val separator: String) {
        COMMA(","),
        DOT("."),
        SPACE(" ")
    }
}
