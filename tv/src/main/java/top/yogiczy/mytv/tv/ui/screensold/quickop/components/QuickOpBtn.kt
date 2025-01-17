package top.yogiczy.mytv.tv.ui.screensold.quickop.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ClickableSurfaceDefaults
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import top.yogiczy.mytv.tv.ui.utils.handleKeyEvents

@Composable
fun QuickOpBtn(
    modifier: Modifier = Modifier,
    title: String,
    imageVector: ImageVector? = null,
    onSelect: () -> Unit = {},
    onLongSelect: () -> Unit = {},
) {
    Surface(
        modifier = modifier
            .handleKeyEvents(onSelect = onSelect, onLongSelect = onLongSelect),
        onClick = {},
        colors = ClickableSurfaceDefaults.colors(
            containerColor = MaterialTheme.colorScheme.onSurface.copy(0.1f),
            contentColor = MaterialTheme.colorScheme.onSurface,
            focusedContainerColor = MaterialTheme.colorScheme.inverseSurface,
            focusedContentColor = MaterialTheme.colorScheme.inverseOnSurface,
        ),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            imageVector?.let {
                Icon(it, null, Modifier.size(20.dp))
            }

            Text(text = title, modifier = Modifier.animateContentSize())
        }
    }
}
