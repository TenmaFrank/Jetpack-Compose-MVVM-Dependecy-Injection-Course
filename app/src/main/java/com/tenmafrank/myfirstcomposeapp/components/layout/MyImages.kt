package com.tenmafrank.myfirstcomposeapp.components.layout

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tenmafrank.myfirstcomposeapp.R
/*
images and icons
 */
@Preview()
@Composable
fun MyImages(modifier: Modifier = Modifier){
    Column {
        Image(
            painter = painterResource(R.drawable.newnewkumikopic),
            contentDescription = "avatar image profile",
            modifier = modifier.height(12.dp).width(50.dp),
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(R.drawable.newnewkumikopic),
            contentDescription = "avatar image profile",
            modifier = modifier
                .size(300.dp)
                .clip(shape = RoundedCornerShape(50))
                .border(width = 5.dp, shape = CircleShape,
                    brush = Brush.linearGradient(colors =  listOf(Color.Red, Color.Blue, Color.Yellow, Color.Green))),
            contentScale = ContentScale.FillBounds
        )

        AsyncImage(
            model = "https://coil-kt.github.io/coil/logo.svg",
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier.size(50.dp),
            onError = {
                Log.e("imageur;", "ha ocurrido un error ${it.result.throwable.message}")
            })

        Icon(
            painter = painterResource(R.drawable.ic_person),
            contentDescription = null,
            modifier = modifier.size(300.dp),
            tint = Color.Blue
            )
    }
}