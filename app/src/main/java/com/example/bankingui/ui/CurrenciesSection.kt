package com.example.bankingui.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingui.data.CurrenciesItems
import com.example.bankingui.ui.theme.GreenStart
import com.example.bankingui.ui.theme.OrangeStart


val currencyItems = listOf(
    CurrenciesItems(
        name = "USD",
        buy = 23.35f,
        sell = 23.25f,
        icon = Icons.Rounded.AttachMoney
    ),
    CurrenciesItems(
        name = "EUR",
        buy = 13.35f,
        sell = 13.35f,
        icon = Icons.Rounded.Euro
    ),
    CurrenciesItems(
        name = "YEN",
        buy = 23.35f,
        sell = 22.35f,
        icon = Icons.Rounded.CurrencyYen
    ),
    CurrenciesItems(
        name = "USD",
        buy = 26.35f,
        sell = 26.25f,
        icon = Icons.Rounded.AttachMoney
    ),
    CurrenciesItems(
        name = "EUR",
        buy = 16.35f,
        sell = 16.25f,
        icon = Icons.Rounded.Euro
    ),
    CurrenciesItems(
        name = "YEN",
        buy = 27.35f,
        sell = 27.25f,
        icon = Icons.Rounded.CurrencyYen
    ),
)


@Preview(showBackground = true)
@Composable
fun CurrenciesSection() {

    var isVisible by rememberSaveable{
        mutableStateOf(false)
    }

    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()

        ) {

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .clickable {
                            isVisible = !isVisible

                            iconState = if (isVisible) {
                                Icons.Rounded.KeyboardArrowDown
                            } else {
                                Icons.Rounded.KeyboardArrowUp
                            }
                        }
                ) {
                    Icon(
                        imageVector = iconState,
                        contentDescription = "currencies",
                        tint = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier.size(25.dp)
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .fillMaxWidth()
            )

            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)

                    ) {
                        Spacer(modifier = Modifier.height(1.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(OrangeStart)
                                    .padding()
                                    .clip(RoundedCornerShape(6.dp))
                            ) {
                                Text(
                                    text = "Currency",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier
                                        .width(width)

                                )
                            }
                            Box(
                                modifier = Modifier
                                    .background(GreenStart)
                                    .padding(end = 10.dp)
                            ) {
                                Text(
                                    text = "Buy",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .width(width)

                                )
                            }
                            Box(
                                modifier = Modifier
                                    .background(Color.Red)
                                    .padding(end = 10.dp)
                                    .clip(RoundedCornerShape(6.dp))
                            ) {
                                Text(
                                    text = "Sell",
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .width(width)

                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(max = 300.dp)
                        ) {
                            items(currencyItems.size) { index ->
                                CurrencyItem(index, width)
                            }
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun CurrencyItem(index: Int, width: Dp) {

    val currency = currencyItems[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp,),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }

            Text(
                text = currency.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .padding(start = 10.dp)

            )
        }
            Text(
                text = "Ksh ${currency.buy}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .width(width)
                    .padding(start = 10.dp)

            )
            Text(
                text = "Ksh ${currency.sell}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .width(width)
                    .padding(start = 10.dp)
            )
        }
}