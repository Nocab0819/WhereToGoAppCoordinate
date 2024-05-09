package com.example.WhereToGoApp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.WhereToGoApp.R
import com.example.WhereToGoApp.ui.components.ChangeImage
import com.example.WhereToGoApp.ui.theme.WhereToGoAppTheme

@Composable
fun IntroductionScreen(
    subtotal: Int,
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))) {
            ChangeImage(subtotal = subtotal,  modifier = Modifier)
        }
    }

}

@Preview
@Composable
fun SelectOptionPreview() {
    WhereToGoAppTheme {
        IntroductionScreen(
            subtotal = 299,
            modifier = Modifier.fillMaxHeight()
        )
    }
}
