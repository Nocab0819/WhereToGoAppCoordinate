package com.example.WhereToGoApp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.WhereToGoApp.R
import com.example.WhereToGoApp.data.DataSource
import com.example.WhereToGoApp.data.PlaceNumber
import com.example.WhereToGoApp.ui.theme.WhereToGoAppTheme

@Composable
fun SelectPlaceScreen(
    placeOptions: List<PlaceNumber>,
    onNextButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.padding_medium)
            )
        ) {
            placeOptions.forEach { item ->
                SelectPlaceButton(
                    imageId = item.imageId,
                    nameId = item.nameId,
                    onClick = { onNextButtonClicked(item.number) },
                    modifier = Modifier
                        .padding(3.dp),
                )
            }
        }
    }
}

@Composable
fun SelectPlaceButton(
    @DrawableRes imageId: Int,
    @StringRes nameId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 8.dp,
    fontSize: TextUnit = 21.sp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
    ) {
        Card (
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            modifier = Modifier.fillMaxWidth(),
        ){
            Row (verticalAlignment = Alignment.CenterVertically){
                Image(
                    modifier = modifier
                        .size(65.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(imageId),
                    contentDescription = null,
                )
                Spacer(Modifier.width(20.dp))
                Text(
                    modifier = modifier,
                    text = stringResource(nameId),
                    fontSize = fontSize
                )
            }
        }
    }
}
@Preview
@Composable
fun StartOrderPreview() {
    WhereToGoAppTheme {
        SelectPlaceScreen(
            placeOptions = DataSource.placeOptions,
            onNextButtonClicked = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_small))
        )
    }
}
