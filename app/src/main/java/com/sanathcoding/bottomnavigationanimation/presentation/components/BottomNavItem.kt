package com.sanathcoding.bottomnavigationanimation.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sanathcoding.bottomnavigationanimation.presentation.Screen

@Composable
fun BottomNavItem(
    modifier: Modifier = Modifier,
    screen: Screen,
    isSelected: Boolean,
    activatedColor: Color = MaterialTheme.colorScheme.primary,
    inactivateColor: Color = Color.Transparent,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        val animatedWidth by animateDpAsState(targetValue = if (isSelected) 120.dp else 48.dp)
        Row(
            modifier = Modifier
                .width(animatedWidth)
                .height(48.dp)
                .background(
                    color = if (isSelected) activatedColor else inactivateColor,
                    shape = RoundedCornerShape(12.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = if (isSelected) screen.activeIcon else screen.inactiveIcon,
                contentDescription = null
            )
            if (isSelected) {
                Text(
                    text = screen.title,
                    modifier = Modifier.padding(
                        start = 8.dp,
                        end = 10.dp,
                    ),
                    maxLines = 1,
                )
            }
        }
    }
}