/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.WhereToGoApp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.WhereToGoApp.R
import com.example.WhereToGoApp.data.PlaceInformation


@Composable
fun ChangeImage(
    subtotal: Int,
    modifier: Modifier,
    onNextButtonClicked: () -> Unit = {},
    fontSize: TextUnit = 18.sp
){
    val imageResource = remember(subtotal) {
        when (subtotal) {
            1 -> PlaceInformation(R.drawable.image_1,R.string.name_1, R.string.introduction_1)
            2 -> PlaceInformation(R.drawable.image_2,R.string.name_2, R.string.introduction_2)
            3 -> PlaceInformation(R.drawable.image_3,R.string.name_3, R.string.introduction_3)
            4 -> PlaceInformation(R.drawable.image_4,R.string.name_4, R.string.introduction_4)
            5 -> PlaceInformation(R.drawable.image_5,R.string.name_5, R.string.introduction_5)
            6 -> PlaceInformation(R.drawable.image_6,R.string.name_6, R.string.introduction_6)
            7 -> PlaceInformation(R.drawable.image_7,R.string.name_7, R.string.introduction_7)
            8 -> PlaceInformation(R.drawable.image_8,R.string.name_8, R.string.introduction_8)
            9 -> PlaceInformation(R.drawable.image_9,R.string.name_9, R.string.introduction_9)
            else -> PlaceInformation(R.drawable.image_10,R.string.name_10, R.string.introduction_10)
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
                fontSize = 28.sp,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
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
                    onClick = onNextButtonClicked,
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
