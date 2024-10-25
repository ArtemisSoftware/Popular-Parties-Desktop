@file:OptIn(ExperimentalMaterial3Api::class)

package core.ui.composables.topbar

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun PPTopBar(
    title: String,
    onBackClick: () -> Unit
){
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Localized description")
            }
        }
    )
}

@Preview
@Composable
private fun PPTopBarPreview() {
    PPTopBar(
        title = "Title",
        onBackClick = {}
    )
}