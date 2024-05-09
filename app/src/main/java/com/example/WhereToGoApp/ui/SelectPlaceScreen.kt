package com.example.WhereToGoApp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.WhereToGoApp.R
import com.example.WhereToGoApp.data.DataSource
import com.example.WhereToGoApp.ui.theme.WhereToGoAppTheme

@Composable
fun SelectPlaceScreen(
    placeOptions: List<Pair<Int, Int>>,
    onNextButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
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
                    labelResourceId = item.first,
                    onClick = { onNextButtonClicked(item.second) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp),
                )
            }
        }
    }
}

@Composable
fun SelectPlaceButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 8.dp,
    fontSize: TextUnit = 18.sp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 250.dp)
            .heightIn(min = 80.dp)
            .padding(3.dp),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)

    ) {
        Text(
            text = stringResource(labelResourceId),
            fontSize = fontSize
        )
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
