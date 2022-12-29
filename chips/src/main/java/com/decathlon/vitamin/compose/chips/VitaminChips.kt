package com.decathlon.vitamin.compose.chips

import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.decathlon.vitamin.compose.foundation.VitaminTheme

object VitaminChips {

    /**
     * Action chip offers actions related to the content related to.
     * It appears dynamically and contextually in the interface.
     *
     * @param label Text to be displayed into the Chip
     * @param `Modifier` to be applied to the component
     * @param enabled True if you can click on the Chip, otherwise false
     * @param colors Colors to be applied to the Chip
     * @param sizes Sizes to be applied to the Chip. (VitaminChipSizes.medium() | VitaminChipSizes.small())
     * @param ripple The ripple effect to be applied to the Chip
     * @param onClick Callback to be called when the action Chip is clicked
     * @param leadingIcon Optional Icon Content to be displayed before label into the Chip
     */

    @Composable
    fun Action(
        label: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        colors: VitaminChipColors = VitaminChipDefaults.default(),
        sizes: ChipSizes = VitaminChipSizes.medium(),
        ripple: RippleTheme = VitaminTheme.ripples.brand,
        onClick: () -> Unit,
        leadingIcon: (@Composable () -> Unit)? = null
    ) {
        VitaminChipImpl(
            label = label,
            modifier = modifier,
            enabled = enabled,
            colors = colors,
            sizes = sizes,
            ripple = ripple,
            onClick = onClick,
            leadingIcon = leadingIcon
        )
    }

    @Composable
    fun Input(
        label: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        colors: VitaminSelectableChipColors = VitaminChipDefaults.selectable(),
        sizes: ChipSizes = VitaminChipSizes.medium(),
        ripple: RippleTheme = VitaminTheme.ripples.brand,
        onClick: () -> Unit,
        trailingIcon: (@Composable () -> Unit) = { VitaminChipButtons.Close(contentDescription = null) }
    ) {
        VitaminFilterChipImpl(
            label = label,
            modifier = modifier,
            enabled = enabled,
            colors = colors,
            sizes = sizes,
            ripple = ripple,
            onClick = onClick,
            trailingIcon = trailingIcon
        )
    }

    @Composable
    fun InputWithIcon(
        label: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        colors: VitaminSelectableChipColors = VitaminChipDefaults.selectable(),
        sizes: ChipSizes = VitaminChipSizes.medium(),
        ripple: RippleTheme = VitaminTheme.ripples.brand,
        onClick: () -> Unit,
        leadingIcon: (@Composable () -> Unit),
        trailingIcon: (@Composable () -> Unit) = { VitaminChipButtons.Close(contentDescription = null) }
    ) {
        VitaminFilterChipImpl(
            label = label,
            modifier = modifier,
            enabled = enabled,
            colors = colors,
            sizes = sizes,
            ripple = ripple,
            onClick = onClick,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }

    @Composable
    fun InputWithImage(
        label: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        colors: VitaminSelectableChipColors = VitaminChipDefaults.selectable(),
        sizes: ChipSizes = VitaminChipSizes.medium(),
        ripple: RippleTheme = VitaminTheme.ripples.brand,
        onClick: () -> Unit,
        leadingContent: (@Composable () -> Unit),
        trailingIcon: (@Composable () -> Unit) = { VitaminChipButtons.Close(contentDescription = null) }
    ) {
        VitaminFilterChipImpl(
            label = label,
            modifier = modifier,
            enabled = enabled,
            colors = colors,
            sizes = sizes,
            ripple = ripple,
            onClick = onClick,
            leadingContent = leadingContent,
            trailingIcon = trailingIcon
        )
    }

    @Composable
    fun Filter(
        label: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        selected: Boolean = false,
        colors: VitaminSelectableChipColors = VitaminChipDefaults.selectable(),
        sizes: ChipSizes = VitaminChipSizes.medium(),
        ripple: RippleTheme = VitaminTheme.ripples.brand,
        onClick: () -> Unit,
        selectedIcon: (@Composable () -> Unit) = { VitaminChipButtons.Selected() }
    ) {
        val leadingContent = if (selected) {
            selectedIcon
        } else {
            null
        }
        VitaminFilterChipImpl(
            label = label,
            modifier = modifier,
            enabled = enabled,
            selected = selected,
            colors = colors,
            sizes = sizes,
            ripple = ripple,
            onClick = onClick,
            leadingIcon = leadingContent
        )
    }

    @Composable
    fun SingleChoice(
        label: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        selected: Boolean = false,
        colors: VitaminSelectableChipColors = VitaminChipDefaults.selectable(),
        sizes: ChipSizes = VitaminChipSizes.medium(),
        ripple: RippleTheme = VitaminTheme.ripples.brand,
        onClick: () -> Unit
    ) {
        VitaminFilterChipImpl(
            label = label,
            modifier = modifier,
            enabled = enabled,
            selected = selected,
            colors = colors,
            sizes = sizes,
            ripple = ripple,
            onClick = onClick
        )
    }
}
