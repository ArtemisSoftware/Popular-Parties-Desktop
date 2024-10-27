package presentation.addevent.composables

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.designsystem.Grey10
import core.designsystem.Grey40
import core.ui.composables.button.PPCircularIconButton
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import presentation.util.UrlUtil
import java.io.IOException

@Composable
internal fun HtmlViewer(
    htmlContent: String,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .verticalScroll(scrollState)
            .border(
                BorderStroke(1.dp, color = Grey40),
                shape = MaterialTheme.shapes.extraSmall
            )
            .background(color = Grey10)
            .padding(16.dp)
    ) {
        BasicTextField(
            value = htmlContent,
            onValueChange = {  },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 16.sp),  // Style it like a Text component
            readOnly = false  // Makes it non-editable
        )
    }
}



@Preview
@Composable
private fun HtmlViewerPreview() {
    HtmlViewer(
        modifier = Modifier.fillMaxWidth(),
        htmlContent = "",
    )
}