package com.example.bankingui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankingui.ui.HomeScreen
import com.example.bankingui.ui.theme.BankingUITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingUITheme(darkTheme = false) {
                SetStatusBarColor(color = MaterialTheme.colorScheme.background)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyBankApp(
                        modifier = Modifier
                            .padding(innerPadding)

                    )
                }
            }
        }
    }

    @Composable
    private fun SetStatusBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }

}

@Composable
fun MyBankApp(modifier: Modifier = Modifier) {
    HomeScreen()
}