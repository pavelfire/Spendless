package com.vk.directop.spendless.presentation.registration

sealed interface RegistrationAction {
    data class OnUsernameChange(val username: String) : RegistrationAction
}