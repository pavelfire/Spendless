package com.vk.directop.spendless.presentation.preferences

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vk.directop.spendless.presentation.preferences.component.ThousandsSeparator

@Composable
fun PreferencesScreen(
    state: PreferencesState,
    onAction: (PreferencesAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 36.dp)
    ) {
        ThousandsSeparator(
            selectedSeparator = state.thousandsSeparator,
            onItemSelected = { separator ->
                onAction(PreferencesAction.OnThousandsSeparatorChange(separator))
            }
        )
    }
}