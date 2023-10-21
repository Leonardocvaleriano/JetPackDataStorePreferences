package com.codeplace.jetpackdatastorepreferences


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codeplace.jetpackdatastorepreferences.ui.theme.HomeViewModel
import com.codeplace.jetpackdatastorepreferences.ui.theme.JetPackDataStorePreferencesTheme
import com.codeplace.jetpackdatastorepreferences.ui.theme.Screens.HomeScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

// Objective: When the user click on a button, change a value of an val from true to false.


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackDataStorePreferencesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel:HomeViewModel = koinViewModel()
                    val isFirstUserAccess = viewModel.isFirstUserAccess.collectAsStateWithLifecycle()


                   LaunchedEffect(key1 = Unit){
                       lifecycleScope.launch {
                           viewModel.readState()
                       }
                   }

                    HomeScreen(isFirstUserAccess = isFirstUserAccess.value,
                        changePropertyStateOnClick = {
                            lifecycleScope.launch {
                                viewModel.saveAppEntry()
                            }
                        })
                }
            }
        }
    }
}

