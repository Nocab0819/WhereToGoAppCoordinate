package com.example.WhereToGoApp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

data class PlaceUiState(
    val placeNumber: Int = 0,
)

data class PlaceInformation(
    @DrawableRes val imageResourceId: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val introductionResourceId: Int,
    val url: String,
)