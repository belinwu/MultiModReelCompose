package com.ibrahimkurt.core.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.DefaultModelEqualityDelegate
import coil.compose.EqualityDelegate

@Composable
fun CoilImage(
    model: Any?,
    contentDescription: String?,
    imageLoader: ImageLoader,
    modifier: Modifier = Modifier,
    transform: (AsyncImagePainter.State) -> AsyncImagePainter.State = AsyncImagePainter.DefaultTransform,
    onState: ((AsyncImagePainter.State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
    clipToBounds: Boolean = true,
    modelEqualityDelegate: EqualityDelegate = DefaultModelEqualityDelegate,
) {
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        imageLoader = imageLoader,
        modifier = modifier,
        transform = transform,
        onState = onState,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        filterQuality = filterQuality,
        clipToBounds = clipToBounds,
        modelEqualityDelegate = modelEqualityDelegate,
    )
}

@ReelPreview
@Composable
private fun CoilImagePreview() {
    CoilImage(
        model = null,
        contentDescription = null,
        imageLoader = ImageLoader(LocalContext.current)
    )
}