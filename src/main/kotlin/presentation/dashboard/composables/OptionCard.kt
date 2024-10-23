@file:OptIn(ExperimentalFoundationApi::class)

package presentation.dashboard.composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import presentation.dashboard.models.DashboardOption

@Composable
internal fun OptionCard(
    option: DashboardOption,
    onClick: (DashboardOption) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .onClick { onClick(option) },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = option.icon,
                contentDescription = ""
            )
            Text(
                text = option.description,
                modifier = Modifier,
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Preview
@Composable
private fun OptionCardPreview() {
    OptionCard(
        modifier = Modifier.fillMaxWidth(),
        option = DashboardOption.AddEvent,
        onClick = {}
    )
}