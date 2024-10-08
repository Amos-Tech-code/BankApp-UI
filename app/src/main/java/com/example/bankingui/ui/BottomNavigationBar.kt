package com.example.bankingui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bankingui.data.BottomNavigationItem


val navigationItems = listOf(
    BottomNavigationItem(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavigationItem(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),
    BottomNavigationItem(
        title = "Notifications",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavigationItem(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)

@Composable
fun BottomNavigationBar() {
    NavigationBar(

    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {

            navigationItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }

        }
    }
}
