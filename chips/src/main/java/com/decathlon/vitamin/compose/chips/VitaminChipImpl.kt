package com.decathlon.vitamin.compose.chips

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.VtmnStatesDisabled

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun VitaminChipImpl(
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: VitaminChipColors = VitaminChipDefaults.default(),
    sizes: ChipSizes = VitaminChipSizes.medium(),
    ripple: RippleTheme = VitaminTheme.ripples.brand,
    onClick: () -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null
) {
    CompositionLocalProvider(
        LocalRippleTheme provides ripple,
        LocalContentAlpha provides colors.contentColor(enabled = enabled).value.alpha
    ) {
        Chip(
            modifier = modifier,
            content = {
                if (leadingIcon == null) {
                    Spacer(modifier = Modifier.width(sizes.horizontalSpacing()))
                }
                Text(
                    modifier = Modifier.padding(
                        top = sizes.verticalPadding,
                        bottom = sizes.verticalPadding
                    ),
                    text = label,
                    color = colors.contentColor(enabled = enabled).value,
                    fontSize = sizes.fontSize,
                    fontWeight = sizes.fontWeight,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.width(sizes.horizontalSpacing()))
            },
            shape = CircleShape,
            border = BorderStroke(
                sizes.borderWidth,
                colors.borderColor(enabled = enabled).value
            ),
            colors = colors,
            enabled = enabled,
            leadingIcon = {
                leadingIcon?.let {
                    Box(
                        modifier = Modifier
                            .padding(start = sizes.leadingIconStartSpacing())
                            .size(sizes.iconSize)
                            .alpha(if (enabled) 1F else VtmnStatesDisabled)
                    ) {
                        leadingIcon()
                    }
                }
            },
            onClick = onClick
        )
    }
}
