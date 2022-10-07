package com.psycodeinteractive.fbimostwanted.ui.widget.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.psycodeinteractive.fbimostwanted.ui.R
import com.psycodeinteractive.fbimostwanted.ui.widget.FBIMostWantedLazyRow
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun HorizontalImageGallery(
    modifier: Modifier = Modifier,
    urls: List<String>
) {
    FBIMostWantedLazyRow(
        modifier = modifier.padding(horizontal = galleryHorizontalPadding),
        items = urls
    ) { url ->
        CoilImage(
            modifier = Modifier.fillMaxHeight(),
            imageModel = url,
            imageOptions = ImageOptions(
                contentScale = Fit
            ),
            failure = {
                ImageFetchFailure()
            }
        )
    }
}

@Composable
private fun BoxScope.ImageFetchFailure() {
    Image(
        modifier = Modifier.fillMaxHeight()
            .aspectRatio(ratio = 1.0f, matchHeightConstraintsFirst = true)
            .size(imageFetchFailureImageSize)
            .align(Center),
        painter = painterResource(id = R.drawable.image_broken),
        contentDescription = "ImageFetchFailure",
        colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
    )
}

private val galleryHorizontalPadding = 10.dp
private val imageFetchFailureImageSize = 60.dp
