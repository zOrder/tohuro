package ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ui.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheChip(
    label: String,
    isSelected: Boolean,
    onClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    painter: ImageVector? = null
) {
    val containerColor by animateColorAsState(
        targetValue = if (isSelected) Theme.colors.primary else Theme.colors.divider
    )
    val labelColor by animateColorAsState(
        targetValue = if (isSelected) Theme.colors.onPrimary
        else Theme.colors.onPrimary
    )
    val iconColor by animateColorAsState(
        targetValue = if (isSelected) Theme.colors.onPrimary
        else Theme.colors.secondary
    )
    AssistChip(
        modifier = modifier.height(32.dp),
        onClick = { onClick(!isSelected) },
        label = { Text(text = label, style = Theme.typography.titleMedium) },
        leadingIcon = {
            painter?.let {
                Icon(
                    painter,
                    contentDescription = "$label icon",
                    Modifier.size(AssistChipDefaults.IconSize),
                    tint = iconColor
                )
            }
        },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = containerColor,
            labelColor = labelColor
        ),
        border = AssistChipDefaults.assistChipBorder(
            borderColor = Theme.colors.divider,
            borderWidth = 1.dp
        ),
        shape = RoundedCornerShape(Theme.radius.small)
    )
}