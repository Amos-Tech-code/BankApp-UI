package com.example.bankingui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingui.R
import com.example.bankingui.data.CardItems
import com.example.bankingui.ui.theme.BlueEnd
import com.example.bankingui.ui.theme.BlueStart
import com.example.bankingui.ui.theme.GreenEnd
import com.example.bankingui.ui.theme.GreenStart
import com.example.bankingui.ui.theme.OrangeEnd
import com.example.bankingui.ui.theme.OrangeStart
import com.example.bankingui.ui.theme.PurpleEnd
import com.example.bankingui.ui.theme.PurpleStart


val cardItems = listOf(
    CardItems(
        cardType = "VISA",
        cardNumber = "3452 2344 7886 9901",
        cardName = "Business",
        balance = 89.346,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    CardItems(
        cardType = "MASTER CARD",
        cardNumber = "6652 2334 7226 1903",
        cardName = "Savings",
        balance = 77.345,
        color = getGradient(BlueStart, BlueEnd)
    ),
    CardItems(
        cardType = "VISA",
        cardNumber = "0052 1114 7126 5501",
        cardName = "School Card",
        balance = 3.304,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    CardItems(
        cardType = "MASTER CARD",
        cardNumber = "1212 0032 7721 2900",
        cardName = "Business",
        balance = 26.345,
        color = getGradient(GreenStart, GreenEnd)
    )
)


fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {

    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}



@Preview(showBackground = true)
@Composable
fun CardsSection() {
    LazyRow {
        items(cardItems.size) { index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(index: Int) {

    val card = cardItems[index]

    var lastItemPaddingEnd = 0.dp

    if (index == cardItems.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_mastercard)
    
    if (card.cardType == "VISA") {
        image = painterResource(id = R.drawable.ic_visa )
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
       Column(
           modifier = Modifier
               .clip(RoundedCornerShape(25.dp))
               .background(card.color)
               .width(250.dp)
               .height(120.dp)
               .padding(vertical = 10.dp, horizontal = 16.dp),
           verticalArrangement = Arrangement.SpaceBetween
       ) {
           Image(
               painter = image,
               contentDescription = card.cardName,
               modifier = Modifier.width(50.dp)
           )

           Spacer(modifier = Modifier.height(1.dp))

           Text(
               text = card.cardName,
               color = Color.White,
               fontSize = 14.sp,
               fontWeight = FontWeight.Bold
           )
           Text(
               text = " Ksh " + card.balance.toString(),
               color = Color.White,
               fontSize = 17.sp,
               fontWeight = FontWeight.Bold
           )
           Text(
               text = card.cardNumber,
               color = Color.White,
               fontSize = 14.sp,
               fontWeight = FontWeight.Bold
           )
       }
    }
}