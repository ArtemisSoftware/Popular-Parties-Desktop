package core.ui.composables.button

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BlurCircular
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PPCircularIconButton(
    onClick: () -> Unit,
    icon: ImageVector,
    size: Dp = 48.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentDescription: String? = null
) {
    Surface(
        modifier = Modifier.size(size),
        shape = CircleShape,
        color = backgroundColor
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun PPCircularIconButtonPreview() {
    PPCircularIconButton(
        onClick = {},
        icon = Icons.Filled.BlurCircular
    )
}