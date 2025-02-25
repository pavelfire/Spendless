package com.vk.directop.spendless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vk.directop.spendless.presentation.preferences.PreferencesScreen
import com.vk.directop.spendless.presentation.preferences.PreferencesViewModel
import com.vk.directop.spendless.presentation.registration.RegistrationScreen
import com.vk.directop.spendless.presentation.registration.RegistrationViewModel
import com.vk.directop.spendless.ui.theme.SpendLessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendLessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "preferences"
                    ) {
                        composable("registration") {
                            val viewModel = viewModel<RegistrationViewModel>()
                            RegistrationScreen(
                                state = viewModel.state,
                                onAction = viewModel::onAction,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        composable("preferences") {
                            val viewModel = viewModel<PreferencesViewModel>()
                            PreferencesScreen(
                                state = viewModel.state,
                                onAction = viewModel::onAction,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}

