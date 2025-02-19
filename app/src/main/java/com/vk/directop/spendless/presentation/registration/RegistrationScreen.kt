package com.vk.directop.spendless.presentation.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vk.directop.spendless.R
import com.vk.directop.spendless.ui.theme.ErrorBackground
import com.vk.directop.spendless.ui.theme.FigtreeFontFamily

@Composable
fun RegistrationScreen(
    state: RegistrationState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(top = 36.dp, bottom = 20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.icon),
            contentDescription = "Cancel",
            modifier = modifier
                .padding(vertical = 26.dp)
        )
        Text(
            text = "Welcome to SpendLess!\nHow can we address you?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FigtreeFontFamily,
            textAlign = TextAlign.Center,
            lineHeight = 36.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Create unique username",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FigtreeFontFamily,
            modifier = Modifier.padding(top = 8.dp, bottom = 36.dp)
        )
        OutlinedTextField(
            value = "value",
            onValueChange = {},
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.LightGray,
                focusedContainerColor = Color.LightGray,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
            ),
            textStyle = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FigtreeFontFamily,
                textAlign = TextAlign.Center
            )
        )
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .height(56.dp)
                .clip(RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Next")
                Spacer(Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "arrow next",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Spacer(Modifier.height(12.dp))
        Text(
            text = "Already have an account?",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FigtreeFontFamily,
            modifier = Modifier
                .clickable { }
        )
        Spacer(Modifier.height(12.dp))
        if (state.isError) {
            Text(
                text = "This username has already been taken!",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = FigtreeFontFamily,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ErrorBackground)
                    .padding(16.dp)


            )
        }
    }
}

@Preview
@Composable
private fun RegistrationScreenPreview() {
    MaterialTheme {
        RegistrationScreen(
            state = RegistrationState(),
            modifier = Modifier
                .background(Color.White)
        )
    }
}