package com.decathlon.vitamin.compose.appbars

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.decathlon.vitamin.compose.dropdown.VitaminMenus

@Composable
internal fun OverflowMenu(
    actions: List<ActionItem>,
    modifier: Modifier = Modifier,
    onDismissRequest: (() -> Unit)? = null,
    expanded: MutableState<Boolean> = remember { mutableStateOf(false) },
    overflowIcon: @Composable VitaminMenuIconButtons.() -> Unit
) {
    VitaminMenus.Dropdown(
        expanded = expanded,
        modifier = modifier,
        onDismissRequest = {
            onDismissRequest?.let { it() }
        },
        anchor = {
            VitaminMenuIconButtons.overflowIcon()
        },
        children = {
            actions.forEach {
                PrimaryItem(
                    onClick = {
                        it.onClick()
                        expanded.value = false
                    },
                    content = it.content
                )
            }
        }
    )
}
