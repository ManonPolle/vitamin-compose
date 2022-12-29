package com.decathlon.vitamin.compose.chips.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.decathlon.vitamin.compose.chips.ChipSizes
import com.decathlon.vitamin.compose.chips.VitaminChips

object ChipsVariantsFactory {

    @Suppress("LongMethod")
    @Composable
    fun Chip(
        variant: Variant,
        size: ChipSizes,
        modifier: Modifier = Modifier,
        selected: Boolean = false,
        icon: (@Composable () -> Unit)? = null,
        enabled: Boolean = true,
        text: String = "My Button"
    ) {
        when (variant) {
            Variant.Action -> VitaminChips.Action(
                label = text,
                sizes = size,
                enabled = enabled,
                leadingIcon = icon,
                onClick = {
                    if(selected) {

                    }
                    // Nothing to do here
                },
                modifier = modifier
            )
//            Variant.Filter -> VitaminChips.Filter(
//                label = text,
//                sizes = size,
//                enabled = enabled,
//                selected = selected,
//                onClick = {
//                    // Nothing to do here
//                },
//                modifier = modifier
//            )
//            Variant.Input -> VitaminChips.Input(
//                label = text,
//                sizes = size,
//                enabled = enabled,
//                onClick = {
//                    // Nothing to do here
//                },
//                modifier = modifier
//            )
//            Variant.InputWithIcon -> icon?.let {
//                VitaminChips.InputWithIcon(
//                    label = text,
//                    sizes = size,
//                    enabled = enabled,
//                    leadingIcon = icon,
//                    onClick = {
//                        // Nothing to do here
//                    },
//                    modifier = modifier
//                )
//            }
//            Variant.InputWithImage -> icon?.let {
//                VitaminChips.InputWithImage(
//                    label = text,
//                    sizes = size,
//                    enabled = enabled,
//                    leadingContent = icon,
//                    onClick = {
//                        // Nothing to do here
//                    },
//                    modifier = modifier
//                )
//            }
//            Variant.SingleChoice -> VitaminChips.SingleChoice(
//                label = text,
//                sizes = size,
//                enabled = enabled,
//                onClick = {
//                    // Nothing to do here
//                },
//                modifier = modifier
//            )
        }
    }
}
