package com.example.bankingui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingui.data.FinanceItems
import com.example.bankingui.ui.theme.BlueStart
import com.example.bankingui.ui.theme.GreenStart
import com.example.bankingui.ui.theme.OrangeStart
import com.example.bankingui.ui.theme.PurpleStart


val financeItems = listOf(
    FinanceItems(
        icon = Icons.AutoMirrored.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),
    FinanceItems(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    FinanceItems(
        icon = Icons.AutoMirrored.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),
    FinanceItems(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    )
)


@Preview(showBackground = true)
@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
            items(financeItems.size) {
                FinanceItem(it)
            }
        }
    }
}


@Composable
fun FinanceItem(index: Int) {

    val finance = financeItems[index]
    var lastPadding = 0.dp

    if (index == financeItems.size - 1) {
        lastPadding = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPadding)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(110.dp)
                .padding(13.dp)
                .clickable {},
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }

            Text(
                text = finance.name,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 15.sp,

            )

        }
    }
}