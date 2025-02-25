package com.vk.directop.spendless.presentation.preferences.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.directop.spendless.presentation.preferences.PreferencesState
import com.vk.directop.spendless.ui.theme.FigtreeFontFamily
import com.vk.directop.spendless.ui.theme.SeparatorBackground
import com.vk.directop.spendless.ui.theme.unselectedFontColor

@Composable
fun ThousandsSeparator(
    selectedSeparator: PreferencesState.ThousandsSeparator,
    onItemSelected: (PreferencesState.ThousandsSeparator) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SeparatorBackground, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 4.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        PreferencesState.ThousandsSeparator.entries.forEachIndexed { index, separator ->
            val isSelected = selectedSeparator == separator

            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isSelected) Color.White else Color.Transparent
                    )
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onItemSelected(separator) }
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = when (separator) {
                        PreferencesState.ThousandsSeparator.COMMA -> "1,000"
                        PreferencesState.ThousandsSeparator.DOT -> "1.000"
                        PreferencesState.ThousandsSeparator.SPACE -> "1 000"
                    },
                    color = if (isSelected) Color.Black else unselectedFontColor,
                    fontFamily = FigtreeFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}


@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
private fun ThousandsSeparatorPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            ThousandsSeparator(
                selectedSeparator = PreferencesState.ThousandsSeparator.SPACE,
                onItemSelected = {}
            )
        }
    }
}