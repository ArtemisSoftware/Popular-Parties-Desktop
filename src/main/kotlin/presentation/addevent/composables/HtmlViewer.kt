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
import presentation.util.UrlUtil
import java.io.IOException

@Composable
internal fun HtmlViewer(
    url: String,
    onGetHtmlCode: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    var htmlContent by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        htmlContent = fetchHtmlWithOkHttp(url)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        htmlGetter(
            url = url,
            onGetHtmlCode = {}
        )

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
}

@Composable
private fun htmlGetter(
    url: String,
    onGetHtmlCode: (String) -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = url,
            label = { Text("Página web") },
            onValueChange = {}
        )

        Button(
            onClick = { onGetHtmlCode(url) },
            content = {
                Text("Obter html")
            }
        )
        PPCircularIconButton(
            onClick = {
                UrlUtil.openUrl(url = url)
            },
            icon = Icons.Filled.FindInPage
        )
    }
}


@Preview
@Composable
private fun HtmlViewerPreview() {
    HtmlViewer(
        modifier = Modifier.fillMaxWidth(),
        url = "",
        onGetHtmlCode = {},
    )
}

val client = OkHttpClient()

fun cleanHtmlContent(html: String): String {
    // Replace non-printable characters and trim extra whitespace
    return html.replace(Regex("[\\n\\t\\r]"), "").trim()
}

fun formatHtmlContent(html: String): String {
    // Replace unprintable characters with newlines
    return html.replace(Regex("[\\u0000-\\u001F\\u007F-\\u009F]"), "\n").trim()
}

fun fetchHtmlWithOkHttp(url: String): String {
    val request = Request.Builder().url(url).build()
    client.newCall(request).execute().use { response ->
        return if (!response.isSuccessful) throw IOException("Unexpected code $response") else response.body!!.string()
    }
}