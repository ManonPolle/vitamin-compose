package com.decathlon.vitamin.compose.chips

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.ChipColors
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SelectableChipColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.foundation.VtmnStatesDisabled

@OptIn(ExperimentalMaterialApi::class)
interface VitaminSelectableChipColors : SelectableChipColors {
    /**
     * Represents the border color for this chip, depending on [selected] & [enabled].
     * @param enabled whether the chip is enabled
     * @param selected whether the chip is selected
     */
    @Composable
    fun borderColor(enabled: Boolean, selected: Boolean): State<Color>
}

@OptIn(ExperimentalMaterialApi::class)
interface VitaminChipColors : ChipColors {
    /**
     * Represents the border color for this chip, depending on if [enabled].
     * @param enabled whether the chip is enabled
     */
    @Composable
    fun borderColor(enabled: Boolean): State<Color>
}

@Immutable
internal class VitaminDefaultSelectableChipColors(
    private val backgroundColor: Color,
    private val contentColor: Color,
    private val borderColor: Color,

    private val disabledBackgroundColor: Color,
    private val disabledContentColor: Color,
    private val disabledBorderColor: Color,

    private val selectedBackgroundColor: Color,
    private val selectedContentColor: Color,
    private val selectedBorderColor: Color,

    private val disabledSelectedBackgroundColor: Color,
    private val disabledSelectedContentColor: Color,
    private val disabledSelectedBorderColor: Color
) : VitaminSelectableChipColors {

    @Composable
    override fun backgroundColor(enabled: Boolean, selected: Boolean): State<Color> {
        return animateColorAsState(
            when {
                enabled && !selected -> backgroundColor
                enabled && selected -> selectedBackgroundColor
                !selected -> disabledBackgroundColor
                else -> disabledSelectedBackgroundColor
            }
        )
    }

    @Composable
    override fun contentColor(enabled: Boolean, selected: Boolean): State<Color> {
        return animateColorAsState(
            when {
                enabled && !selected -> contentColor
                enabled && selected -> selectedContentColor
                !selected -> disabledContentColor
                else -> disabledSelectedContentColor
            }
        )
    }

    @Composable
    override fun leadingIconColor(enabled: Boolean, selected: Boolean): State<Color> {
        return contentColor(enabled = enabled, selected = selected)
    }

    @Composable
    override fun borderColor(enabled: Boolean, selected: Boolean): State<Color> {
        return animateColorAsState(
            when {
                enabled && !selected -> borderColor
                enabled && selected -> selectedBorderColor
                !selected -> disabledBorderColor
                else -> disabledSelectedBorderColor
            }
        )
    }
}

@Immutable
internal class VitaminDefaultChipColors(
    private val backgroundColor: Color,
    private val contentColor: Color,
    private val borderColor: Color,

    private val disabledBackgroundColor: Color,
    private val disabledContentColor: Color,
    private val disabledBorderColor: Color
) : VitaminChipColors {
    @Composable
    override fun contentColor(enabled: Boolean): State<Color> {
        return animateColorAsState(
            if (enabled) contentColor else disabledContentColor
        )
    }

    @Composable
    override fun backgroundColor(enabled: Boolean): State<Color> {
        return animateColorAsState(
            if (enabled) backgroundColor else disabledBackgroundColor
        )
    }

    @Composable
    override fun leadingIconContentColor(enabled: Boolean): State<Color> {
        return animateColorAsState(
            if (enabled) contentColor else disabledContentColor
        )
    }

    @Composable
    override fun borderColor(enabled: Boolean): State<Color> {
        return animateColorAsState(
            if (enabled) borderColor else disabledBorderColor
        )
    }
}

object VitaminChipDefaults {
    /**
     * Creates a [VitaminChipColors] that represents the default background and content colors used in
     * a [VitaminChips].
     *
     * @param contentColor the content color of this [VitaminChips] when enabled (not selected)
     * @param backgroundColor the background color of this [VitaminChips] when enabled (not selected)
     * @param borderColor the border color of this [VitaminChips] when enabled (not selected)
     * @param disabledContentColor the content color of this [VitaminChips] when not enabled (not selected)
     * @param disabledBackgroundColor the background color of this [VitaminChips] when not enabled (not selected)
     * @param disabledBorderColor the border color of this [VitaminChips] when not enabled (not selected)
     */
    @Composable
    fun default(
        contentColor: Color = VitaminTheme.colors.vtmnContentAction,
        backgroundColor: Color = VitaminTheme.colors.vtmnBackgroundPrimary,
        borderColor: Color = VitaminTheme.colors.vtmnBorderInactive,

        disabledContentColor: Color = contentColor.copy(alpha = VtmnStatesDisabled),
        disabledBackgroundColor: Color = backgroundColor.copy(alpha = VtmnStatesDisabled),
        disabledBorderColor: Color = borderColor.copy(alpha = VtmnStatesDisabled)
    ): VitaminChipColors = VitaminDefaultChipColors(
        contentColor = contentColor,
        backgroundColor = backgroundColor,
        borderColor = borderColor,
        disabledContentColor = disabledContentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledBorderColor = disabledBorderColor
    )

    /**
     * Creates a [VitaminSelectableChipColors] that represents the default background and content colors used in
     * a [VitaminChips] that is selectable.
     *
     * @param contentColor the content color of this [VitaminChips] when enabled (not selected)
     * @param backgroundColor the background color of this [VitaminChips] when enabled (not selected)
     * @param borderColor the border color of this [VitaminChips] when enabled (not selected)
     * @param selectedContentColor the content color of this [VitaminChips] when enabled & selected
     * @param selectedBackgroundColor the background color of this [VitaminChips] when enabled & selected
     * @param selectedBorderColor the border color of this [VitaminChips] when enabled & selected
     * @param disabledContentColor the content color of this [VitaminChips] when not enabled (not selected)
     * @param disabledBackgroundColor the background color of this [VitaminChips] when not enabled (not selected)
     * @param disabledBorderColor the border color of this [VitaminChips] when not enabled (not selected)
     * @param disabledSelectedContentColor the content color of this [VitaminChips] when not enabled & selected
     * @param disabledSelectedBackgroundColor the background color of this [VitaminChips] when not enabled & selected
     * @param disabledSelectedBorderColor the border color of this [VitaminChips] when not enabled & selected
     */
    @Composable
    fun selectable(
        contentColor: Color = VitaminTheme.colors.vtmnContentAction,
        backgroundColor: Color = VitaminTheme.colors.vtmnBackgroundPrimary,
        borderColor: Color = VitaminTheme.colors.vtmnBorderInactive,

        selectedContentColor: Color = VitaminTheme.colors.vtmnContentPrimaryReversed,
        selectedBackgroundColor: Color = VitaminTheme.colors.vtmnBackgroundBrandPrimary,
        selectedBorderColor: Color = Color.Transparent,

        disabledContentColor: Color = contentColor.copy(alpha = VtmnStatesDisabled),
        disabledBackgroundColor: Color = backgroundColor.copy(alpha = VtmnStatesDisabled),
        disabledBorderColor: Color = borderColor.copy(alpha = VtmnStatesDisabled),

        disabledSelectedContentColor: Color = VitaminTheme.colors.vtmnContentPrimaryReversed,
        disabledSelectedBackgroundColor: Color = selectedBackgroundColor.copy(alpha = VtmnStatesDisabled),
        disabledSelectedBorderColor: Color = Color.Transparent
    ): VitaminSelectableChipColors = VitaminDefaultSelectableChipColors(
        contentColor = contentColor,
        backgroundColor = backgroundColor,
        borderColor = borderColor,
        selectedContentColor = selectedContentColor,
        selectedBackgroundColor = selectedBackgroundColor,
        selectedBorderColor = selectedBorderColor,
        disabledContentColor = disabledContentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledBorderColor = disabledBorderColor,
        disabledSelectedContentColor = disabledSelectedContentColor,
        disabledSelectedBackgroundColor = disabledSelectedBackgroundColor,
        disabledSelectedBorderColor = disabledSelectedBorderColor
    )
}
