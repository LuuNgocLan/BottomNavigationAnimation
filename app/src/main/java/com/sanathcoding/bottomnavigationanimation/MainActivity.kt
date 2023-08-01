package com.sanathcoding.bottomnavigationanimation

import BottomNavAnimation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.sanathcoding.bottomnavigationanimation.presentation.Screen
import com.sanathcoding.bottomnavigationanimation.ui.theme.BottomNavigationAnimationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val screen = listOf(
                Screen.Home,
                Screen.Create,
                Screen.Profile,
                Screen.Settings
            )
            BottomNavigationAnimationTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavAnimation(screens = screen)
                    },
                    content = { padding ->
                        Text(text = "Hello", modifier = Modifier.padding(padding))
                    }
                )

            }
        }
    }
}