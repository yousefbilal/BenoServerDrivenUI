package com.example.benoserverdrivenui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.gson.JsonObject


val layoutMap: HashMap<String, @Composable (modifier: Modifier, content: @Composable () -> Unit) -> Unit> =
    hashMapOf(
        "Box" to { modifier, content ->
            Box(modifier = modifier) {
                content()
            }
        },
        "Column" to { modifier, content ->
            Column(modifier = modifier) {
                content()
            }
        },
        "Row" to { modifier, content ->
            Row(modifier = modifier) {
                content()
            }
        }
    )


val componentMap: HashMap<String, @Composable (modifier: Modifier) -> Unit> =
    hashMapOf("SearchBar" to { modifier -> StatefulSearchBar() })

@Composable
fun JsonToUI(jsonObject: JsonObject) {
    val viewModel = hiltViewModel<MyViewModel>()
    if (jsonObject.has("layoutType")) {
        val layout = layoutMap[jsonObject["layoutType"].asString]

        layout?.invoke(Modifier) {
            jsonObject["components"]
                .asJsonArray
                .forEach { JsonToUI(jsonObject = it.asJsonObject) }
        }
    }
    if (jsonObject.has("component")) {
        val component = componentMap[jsonObject["component"].asString]
        component?.invoke(Modifier)
    }
}

@Composable
fun StatefulSearchBar(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    SearchBar(modifier = modifier, value = text) {
        text = it
    }
}
