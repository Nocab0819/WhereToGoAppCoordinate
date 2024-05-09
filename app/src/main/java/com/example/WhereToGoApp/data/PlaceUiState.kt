package com.example.WhereToGoApp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PlaceUiState(
    val placeNumber: Int = 0,
)

data class PlaceInformation(
    @DrawableRes val imageResourceId: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val introductionResourceId: Int
)