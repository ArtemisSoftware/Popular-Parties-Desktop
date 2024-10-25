@file:OptIn(ExperimentalMaterial3Api::class)

package presentation.addevent

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.ui.composables.topbar.PPTopBar

import okhttp3.OkHttpClient
import okhttp3.Request
import presentation.util.UrlUtil
import java.io.IOException

@Composable
fun AddEventScreen(
    onNavigateBack: () -> Unit
) {
    //HtmlViewer("https://www.example.com")
    AddEventContent(
        onNavigateBack = onNavigateBack
    )
}

@Composable
private fun AddEventContent(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            PPTopBar(
                title = "Criar evento",
                onBackClick = onNavigateBack
            )
        },
        content = { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ){
                EventDetails()
            }
        }
    )
}

@Composable
private fun EventDetails() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = "",
                label = { Text("Página web") },
                onValueChange = {}
            )

            Button(
                onClick = {
                    loadUrl("https://www.coolture.pt/event/feira-da-luz-2024-carnide-lisboa/")
                },
                content = {
                    Text("Validar")
                }
            )
        }
    }
}

private fun loadUrl(url: String){
    UrlUtil.openUrl(url = url)
}

@Preview
@Composable
private fun AddEventContentPreview() {
    AddEventContent(
        onNavigateBack = {}
    )
}

@Preview
@Composable
private fun EventDetailsPreview() {
    EventDetails()
}
/*
val client = OkHttpClient()

fun fetchHtmlWithOkHttp(url: String): String {
    val request = Request.Builder().url(url).build()
    client.newCall(request).execute().use { response ->
        return if (!response.isSuccessful) throw IOException("Unexpected code $response") else response.body!!.string()
    }
}

@Composable
fun HtmlViewer(url: String) {
    var htmlContent by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        htmlContent = fetchHtmlWithOkHttp(url)
    }

    Text(text = if (htmlContent.isEmpty()) "Loading..." else htmlContent)
}
*/