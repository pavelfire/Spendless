package com.vk.directop.spendless.presentation.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {
    var state by mutableStateOf(RegistrationState())
        private set

    fun onAction(action: RegistrationAction) {
        when (action) {
            is RegistrationAction.OnUsernameChange -> {
                state = state.copy(username = action.username)
            }
        }
    }
}