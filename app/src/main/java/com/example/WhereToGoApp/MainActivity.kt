package com.example.WhereToGoApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.WhereToGoApp.ui.theme.WhereToGoAppTheme
import com.example.WhereToGoApp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhereToGoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChangeImages()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeImages(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }

    val imageResource = when (result) {
        1 -> Pair(R.drawable.image_1, "1. Glacier Park")
        2 -> Pair(R.drawable.image_2, "2. Bryce Canyon")
        3 -> Pair(R.drawable.image_3, "3. Red Mountain")
        4 -> Pair(R.drawable.image_4, "4. Paradise Scenery")
        5 -> Pair(R.drawable.image_5, "5. Jupiter Island")
        6 -> Pair(R.drawable.image_6, "6. Autumn Scenery")
        7 -> Pair(R.drawable.image_7, "7. Bath Scenery")
        8 -> Pair(R.drawable.image_8, "8. Hamilton Scenery")
        9 -> Pair(R.drawable.image_9, "9. Castle Scenery")
        else -> Pair(R.drawable.image_10, "10. Winter Lights")
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageResource.first),
            contentDescription = imageResource.second,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(20.dp)
                .height(450.dp)
                //  anchoredDraggable的存取偏移量
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        if (dragAmount.x < 0) {
                            // Left swipe
                            if (result == 10) {
                                result = 1
                            } else {
                                result += 1
                            }
                        } else if (dragAmount.x > 0) {
                            // Right swipe
                            if (result == 1) {
                                result = 10
                            } else {
                                result -= 1
                            }
                        }
                        if (change.positionChange() != Offset.Zero) change.consume()
                    }
                }
        )

        Text(
            text = imageResource.second,
            modifier = Modifier
                .padding(20.dp)
                .background(color = colorResource(id = R.color.LightGray))
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .widthIn(min = 400.dp),
            fontSize = 28.sp,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Previous Button
            PlainTooltipBox(
                tooltip = { Text("Previous photo", fontSize = 16.sp) }
            ) {
                Button(
                    onClick = {
                        if (result == 1) {
                            result = 10
                        } else {
                            result -= 1
                        }
                    },
                    modifier = Modifier
                        .tooltipAnchor()
                        .weight(1f)
                        .widthIn(min = 150.dp)
                        .padding(horizontal = 8.dp)
                ) {
                    Text(text = "Previous", fontSize = 24.sp)
                }
            }
            // Next Button
            PlainTooltipBox(
                tooltip = { Text("Next photo", fontSize = 16.sp) }
            ) {
                Button(
                    onClick = {
                        if (result == 10) {
                            result = 1
                        } else {
                            result += 1
                        }
                    },
                    modifier = Modifier
                        .tooltipAnchor()
                        .weight(1f)
                        .widthIn(min = 150.dp)
                        .padding(horizontal = 8.dp)

                ) {
                    Text(text = "Next", fontSize = 24.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhereToGoAppTheme {
        ChangeImages()
    }
}