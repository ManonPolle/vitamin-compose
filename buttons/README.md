# Button components

## Button design specs

You can find the design specs on [decathlon.design](https://www.decathlon.design/).

## Usage

If you want to use components of this module in your android mobile application, you should
first add the Gradle dependency in your Gradle file:

```kotlin
implementation("com.decathlon.vitamin.compose:buttons:<versions>")
```

### Primary

```kotlin
object VitaminButtons {
    @Composable
    fun Primary(
        text: String,
        modifier: Modifier = Modifier,
        icon: Painter? = null,
        iconSide: IconSide = IconSide.LEFT,
        enabled: Boolean = true,
        size: ButtonSizes = VitaminButtonSizes.mediumSize(),
        onClick: () -> Unit
    )
}
```

The primary button should only be used once per view (not including a modal dialog), 
these buttons have the most emphasis.

The minimal usage of the component is the text of the button but you can add an icon or customize
the size with a small, medium or large size variants.

```kotlin
VitaminButtons.Primary(text = "Primary") {
    // Click event
}
```

Parameters | Descriptions
-- | --
`text: String` | The text inside the button
`modifier: Modifier = Modifier` | The `Modifier` to be applied to the component
`icon: Painter? = null` | The optional icon to be displayed at the start or the end of the button container
`iconSide: IconSide = IconSide.LEFT` | If an icon is added, you can configure the side at the start or end of the button
`enabled: Boolean = true` | True if you can click on the button, otherwise false
`size: ButtonSizes = VitaminButtonSizes.mediumSize()` | Different sizes for the buttons
`onClick: () -> Unit` | The callback to be called when the user click on the button

### All Variants

There are multiple variants of the button with the same parameters:

* `PrimaryReversed`: The primary reversed should be used for primary actions on pictures or dark backgrounds
* `Secondary`: The secondary button is the standard button for most use cases. The outlined styling places less emphasis on these buttons
* `Tertiary`: The tertiary button is usually used for miscellaneous actions: the action is important, but may not be what the user is looking to do right then
* `Ghost`: The ghost button should be used for secondary actions when combined with a primary button or when you need to list multiple actions in one single view as a preference page
* `GhostReversed`: The ghost reversed should be used on pictures or dark backgrounds
* `Conversion`: The conversion button must be used for transactional actions
