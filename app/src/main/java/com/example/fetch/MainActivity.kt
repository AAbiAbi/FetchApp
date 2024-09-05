package com.example.fetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetch.ui.theme.FetchTheme
import com.example.fetch.network.createRetrofitService

import com.example.fetch.network.Item
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchApp()
        }
    }
}

@Composable
fun FetchApp() {
//    Text("App is Running!")
    val service = remember { createRetrofitService() }
    val scope = rememberCoroutineScope()

    var items by remember { mutableStateOf<List<Item>>(emptyList()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    // Fetch data when the UI is loaded
    LaunchedEffect(Unit) {
        scope.launch {
            try {
                val response = service.getItems()
                items = response.filter { it.name != null && it.name.isNotBlank() }
                    .sortedWith(compareBy<Item> { it.listId }.thenBy { it.name })
            } catch (e: Exception) {
                errorMessage = "Failed to load data"
            }
        }
    }
    if (errorMessage != null) {
        Text(text = errorMessage ?: "", color = Color.Red, modifier = Modifier.padding(16.dp))
    }
    // Display the items
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        val groupedItems = items.groupBy { it.listId }
        groupedItems.forEach { (listId, itemsInGroup) ->
            item {
                Text(
                    text = "List ID: $listId",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(itemsInGroup) { item ->
                Text(
                    text = "Name: ${item.name}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Divider()
            }
        }

    }
}
