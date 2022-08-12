package com.decathlon.compose.sample.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.decathlon.compose.sample.R
import com.decathlon.compose.sample.components.SampleScaffold
import com.decathlon.vitamin.compose.chips.VitaminChipSizes
import com.decathlon.vitamin.compose.chips.VitaminChips
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.switches.VitaminSwitches

object Chips : Screen {
    override val name: String
        get() = "Chips"

    override val navigationKey: String
        get() = "chips"

    @OptIn(ExperimentalMaterialApi::class)
    @SuppressWarnings("LongMethod")
    @Composable
    override fun Screen() {
        var actionChipsEnabled by remember { mutableStateOf(true) }
        var filterChipsEnabled by remember { mutableStateOf(true) }
        var inputChipsEnabled by remember { mutableStateOf(true) }
        var singleChoiceChipsEnabled by remember { mutableStateOf(true) }

        SampleScaffold(title = name) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                // ACTION CHIPS
                item {
                    Title(
                        modifier = Modifier.padding(16.dp),
                        title = "Action Chips",
                        defaultEnabled = actionChipsEnabled,
                        onCheckedChanged = { actionChipsEnabled = it }
                    )
                }
                item {
                    ActionRows(actionChipsEnabled)
                }

                // FILTER CHIPS
                item {
                    Title(
                        modifier = Modifier.padding(16.dp),
                        title = "Filter Chips",
                        defaultEnabled = filterChipsEnabled,
                        onCheckedChanged = { filterChipsEnabled = it }
                    )
                }
                item {
                    FilterRows(filterChipsEnabled)
                }

                // INPUT CHIPS
                item {
                    Title(
                        modifier = Modifier.padding(16.dp),
                        title = "Input Chips",
                        defaultEnabled = inputChipsEnabled,
                        onCheckedChanged = { inputChipsEnabled = it }
                    )
                }
                item {
                    InputRows(inputChipsEnabled)
                    InputClosableRows(inputChipsEnabled)
                }

                // SINGLE CHOICE CHIPS
                item {
                    Title(
                        modifier = Modifier.padding(16.dp),
                        title = "Single Choice Chips",
                        defaultEnabled = singleChoiceChipsEnabled,
                        onCheckedChanged = { singleChoiceChipsEnabled = it }
                    )
                }
                item {
                    SingleChoiceChips(singleChoiceChipsEnabled)
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun Title(
    title: String,
    defaultEnabled: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            style = VitaminTheme.typography.h6
        )
        VitaminSwitches.Primary(
            checked = defaultEnabled,
            onCheckedChange = onCheckedChanged
        )
        Text(text = "enabled")
    }
}

@ExperimentalMaterialApi
@SuppressWarnings("LongMethod")
@Composable
private fun ActionRows(actionChipsEnabled: Boolean) {
    Column {
        Row(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            VitaminChips.Action(
                label = "Select",
                onClick = {},
                enabled = actionChipsEnabled,
            )
            VitaminChips.Action(
                label = "Set a reminder",
                enabled = actionChipsEnabled,
                onClick = {},
                startIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vtmn_calendar_line),
                        contentDescription = null
                    )
                }
            )
            VitaminChips.Action(
                label = "Share",
                enabled = actionChipsEnabled,
                onClick = {},
                startIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vtmn_share_line),
                        contentDescription = null
                    )
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
        Row(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            VitaminChips.Action(
                label = "Select",
                onClick = {},
                enabled = actionChipsEnabled,
                sizes = VitaminChipSizes.small()
            )
            VitaminChips.Action(
                label = "Set a reminder",
                enabled = actionChipsEnabled,
                onClick = {},
                sizes = VitaminChipSizes.small(),
                startIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vtmn_calendar_line),
                        contentDescription = null
                    )
                }
            )
            VitaminChips.Action(
                label = "Share",
                enabled = actionChipsEnabled,
                onClick = {},
                sizes = VitaminChipSizes.small(),
                startIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vtmn_share_line),
                        contentDescription = null
                    )
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@ExperimentalMaterialApi
@SuppressWarnings("LongMethod")
@Composable
private fun FilterRows(filterChipsEnabled: Boolean) {
    Column {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val filters = listOf("Basket", "Climbing", "Badminton", "Football")
            val selectedFilters =
                remember { mutableStateListOf("Climbing", "Badminton") }
            Spacer(modifier = Modifier.width(16.dp))
            filters.forEach {
                val selected = selectedFilters.contains(it)
                VitaminChips.Filter(
                    label = it,
                    enabled = filterChipsEnabled,
                    selected = selected,
                    onClick = { isSelected ->
                        if (isSelected) {
                            selectedFilters.remove(it)
                        } else {
                            selectedFilters.add(it)
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val filters = listOf("Basket", "Climbing", "Badminton", "Football")
            val selectedFilters =
                remember { mutableStateListOf("Climbing", "Badminton") }
            Spacer(modifier = Modifier.width(16.dp))
            filters.forEach {
                val selected = selectedFilters.contains(it)
                VitaminChips.Filter(
                    label = it,
                    enabled = filterChipsEnabled,
                    selected = selected,
                    sizes = VitaminChipSizes.small(),
                    onClick = { isSelected ->
                        if (isSelected) {
                            selectedFilters.remove(it)
                        } else {
                            selectedFilters.add(it)
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@ExperimentalMaterialApi
@SuppressWarnings("LongMethod")
@Composable
private fun InputRows(inputChipsEnabled: Boolean) {
    Column {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            var neutralSelected by remember { mutableStateOf(true) }
            VitaminChips.Input(
                label = "Never mind",
                enabled = inputChipsEnabled,
                selected = neutralSelected,
                onClick = {
                    neutralSelected = !neutralSelected
                }
            )
            var drivingSelected by remember { mutableStateOf(false) }
            VitaminChips.Input(
                label = "Driving",
                enabled = inputChipsEnabled,
                selected = drivingSelected,
                onClick = {
                    drivingSelected = !drivingSelected
                },
                startContent = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_vtmn_car_line
                        ),
                        contentDescription = null
                    )
                }
            )
            var walkingSelected by remember { mutableStateOf(true) }
            VitaminChips.Input(
                label = "Walking",
                enabled = inputChipsEnabled,
                selected = walkingSelected,
                onClick = {
                    walkingSelected = !walkingSelected
                },
                startContent = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_vtmn_walk_line
                        ),
                        contentDescription = null
                    )
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            var yogaSelected by remember { mutableStateOf(true) }
            VitaminChips.Input(
                label = "España",
                enabled = inputChipsEnabled,
                selected = yogaSelected,
                onClick = {
                    yogaSelected = !yogaSelected
                },
                startContent = {
                    Image(
                        painter = painterResource(R.drawable.vtmn_flag_es),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        contentDescription = null
                    )
                }
            )
            var boxingSelected by remember { mutableStateOf(false) }
            VitaminChips.Input(
                label = "Belgium",
                enabled = inputChipsEnabled,
                selected = boxingSelected,
                onClick = {
                    boxingSelected = !boxingSelected
                },
                startContent = {
                    Image(
                        painter = painterResource(R.drawable.vtmn_flag_be),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        contentDescription = null
                    )
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            listOf(
                "Nature hiking",
                "Snow hiking",
                "Mountain hiking",
                "Fast hiking"
            ).forEach { value ->
                var selected by remember { mutableStateOf(false) }
                VitaminChips.Input(
                    label = value,
                    enabled = inputChipsEnabled,
                    selected = selected,
                    sizes = VitaminChipSizes.small(),
                    onClick = {
                        selected = !selected
                    }
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun InputClosableRows(inputChipsEnabled: Boolean) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.width(16.dp))

            val displayedContacts =
                remember { mutableStateListOf("John", "Alice", "Helen", "Charles") }
            VitaminChips.Action(
                label = "Re fill",
                enabled = inputChipsEnabled,
                onClick = {
                    displayedContacts.clear()
                    displayedContacts.addAll(listOf("John", "Alice", "Helen", "Charles"))
                },
                startIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vtmn_refresh_line),
                        contentDescription = null
                    )
                }
            )

            displayedContacts.forEach { contact ->
                VitaminChips.Input(
                    label = contact,
                    selected = false,
                    enabled = inputChipsEnabled,
                    onClick = {
                        displayedContacts.remove(contact)
                    },
                    endContent = {
                        Close(contentDescription = "Remove")
                    }
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun SingleChoiceChips(singleChoiceEnabled: Boolean) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.width(16.dp))

        var selected by remember { mutableStateOf("Medium") }
        listOf("Easy", "Medium", "Hard", "Expert").forEach { value ->
            VitaminChips.Input(
                label = value,
                enabled = singleChoiceEnabled,
                selected = value == selected,
                onClick = {
                    selected = value
                }
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
    }
    Row(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.width(16.dp))

        var smallSelected by remember { mutableStateOf("Hard") }
        listOf("Easy", "Medium", "Hard", "Expert").forEach { value ->
            VitaminChips.Input(
                label = value,
                enabled = singleChoiceEnabled,
                selected = value == smallSelected,
                sizes = VitaminChipSizes.small(),
                onClick = {
                    smallSelected = value
                }
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ChipsPreview() {
    VitaminTheme {
        Chips.Screen()
    }
}
