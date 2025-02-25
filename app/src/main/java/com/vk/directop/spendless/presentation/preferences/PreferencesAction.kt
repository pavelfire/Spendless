package com.vk.directop.spendless.presentation.preferences

sealed interface PreferencesAction {
    data class OnThousandsSeparatorChange(val separator: PreferencesState.ThousandsSeparator) :
        PreferencesAction

    data object OnBackPressed : PreferencesAction
}