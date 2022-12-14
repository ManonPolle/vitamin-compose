package com.decathlon.vitamin.compose.chips

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

object VitaminChipButtons {
    @Composable
    fun Close(
        modifier: Modifier = Modifier,
        contentDescription: String? = null,
    ) {
        Icon(
            modifier = modifier,
            painter = painterResource(R.drawable.ic_vtmn_close_line),
            contentDescription = contentDescription
        )
    }

    @Composable
    fun Selected(
        modifier: Modifier = Modifier,
        contentDescription: String? = null,
    ) {
        Icon(
            modifier = modifier,
            painter = painterResource(R.drawable.ic_vtmn_check_line),
            contentDescription = contentDescription
        )
    }
}
