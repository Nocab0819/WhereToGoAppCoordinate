package com.example.WhereToGoApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.WhereToGoApp.R
import com.example.WhereToGoApp.data.PlaceInformation
import com.example.WhereToGoApp.ui.theme.WhereToGoAppTheme

@Composable
fun IntroductionScreen(
    subtotal: Int,
    onNextButtonClicked: (String) -> Unit,
    fontSize: TextUnit = 18.sp,
    modifier: Modifier = Modifier
) {
    val imageResource = remember(subtotal) {
        when (subtotal) {
            1 -> PlaceInformation(R.drawable.image_1,R.string.name_1, R.string.introduction_1, "geo: 22.996911,120.216717")
            2 -> PlaceInformation(R.drawable.image_2,R.string.name_2, R.string.introduction_2, "geo: 25.017305,121.540132")
            3 -> PlaceInformation(R.drawable.image_3,R.string.name_3, R.string.introduction_3, "geo: 24.786046,121.000850")
            4 -> PlaceInformation(R.drawable.image_4,R.string.name_4, R.string.introduction_4, "geo: 25.013404,121.540939")
            5 -> PlaceInformation(R.drawable.image_5,R.string.name_5, R.string.introduction_5, "geo: 24.795546,120.994930")
            6 -> PlaceInformation(R.drawable.image_6,R.string.name_6, R.string.introduction_6, "geo: 24.968189,121.195202")
            7 -> PlaceInformation(R.drawable.image_7,R.string.name_7, R.string.introduction_7, "geo: 24.987465,121.576510")
            8 -> PlaceInformation(R.drawable.image_8,R.string.name_8, R.string.introduction_8, "geo: 25.026435,121.527563")
            9 -> PlaceInformation(R.drawable.image_9,R.string.name_9, R.string.introduction_9, "geo: 25.174190,121.447222")
            else -> PlaceInformation(R.drawable.image_10,R.string.name_10, R.string.introduction_10, "geo: 23.558995,120.472181")
        }
    }
    Box(
        modifier = modifier
            .pointerInput(Unit) {}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = LocalContext.current.getString(imageResource.nameResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                maxLines = Int.MAX_VALUE,
                lineHeight = 40.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Image(
                painter = painterResource(imageResource.imageResourceId),
                contentDescription = stringResource(imageResource.nameResourceId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(5.dp)
                    .height(450.dp)
            )

            Text(
                text = LocalContext.current.getString(imageResource.introductionResourceId),
                modifier = Modifier
                    .padding(10.dp)
                    .background(color = MaterialTheme.colorScheme.secondary)
                    .padding(horizontal = 3.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Start,
                maxLines = Int.MAX_VALUE,
                lineHeight = 40.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
                verticalAlignment = Alignment.Bottom
            ) {
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 50.dp),
                    onClick = {onNextButtonClicked(imageResource.url)},
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        stringResource(R.string.next),
                        fontSize = fontSize,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun SelectOptionPreview() {
    WhereToGoAppTheme {
        IntroductionScreen(
            subtotal = 299,
            onNextButtonClicked = { coordinate: String-> },
            modifier = Modifier.fillMaxHeight()
        )
    }
}
