package com.vk.directop.spendless.presentation.preferences

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PreferencesViewModel : ViewModel() {

    var state by mutableStateOf(PreferencesState())
        private set

    fun onAction(action: PreferencesAction) {
        when (action) {
            is PreferencesAction.OnThousandsSeparatorChange -> onSeparatorSelected(action.separator)
            PreferencesAction.OnBackPressed -> {}
        }
    }

    private fun onSeparatorSelected(separator: PreferencesState.ThousandsSeparator) {
        state = state.copy(thousandsSeparator = separator)
        Log.d("myTag", "selected = ${separator.ordinal}")
    }
}