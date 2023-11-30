package com.zorder.tohuro.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.zorder.tohuro.ui.theme.Theme
import com.zorder.tohuro.ui.theme.Theme.colors
import com.zorder.tohuro.ui.theme.Theme.radius

@Composable
fun TheCheckBox(
    label: String,
    onCheck: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    size: Int = 32,
    isChecked: Boolean = true,
    gapBetweenLabelAndCheckbox: Int = 8,
    textStyle:TextStyle = Theme.typography.titleMedium,
    textColor: Color = colors.contentPrimary,

    ) {
    val checkboxColor: Color by animateColorAsState(
        targetValue = if (isChecked) colors.primary else Color.Transparent,
        animationSpec = tween(Theme.speed.fast)
    )
    val density = LocalDensity.current

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(gapBetweenLabelAndCheckbox.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box( modifier = Modifier
            .size(size.dp)
            .background(color = checkboxColor, shape = RoundedCornerShape(radius.small))
            .border(width = 1.dp, shape = RoundedCornerShape(radius.small),
                color = if (isChecked) colors.primary else colors.divider)
            .toggleable(
                value = isChecked,
                role = Role.Checkbox,
                onValueChange = { onCheck(!isChecked) }
            ),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.animation.AnimatedVisibility(
                visible = isChecked,
                enter = slideInHorizontally(
                    animationSpec = tween(Theme.speed.fast)
                ) {
                    with(density) { (24f * -0.5).dp.roundToPx() }
                } + expandHorizontally(
                    expandFrom = Alignment.Start,
                    animationSpec = tween(Theme.speed.fast)
                ),
                exit = fadeOut()
            ) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = null,
                    tint = White,
                )
            }
        }
        Text(text = label, style = textStyle, color = textColor)
    }
}