package com.example.benoserverdrivenui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.google.gson.Gson
import com.google.gson.JsonObject
import java.io.File


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


val componentMap: HashMap<String, @Composable (modifier: Modifier, jsonArgs: JsonObject?) -> Unit> =
    hashMapOf(
        "SearchBar" to { modifier, jsonArgs ->
            StatefulSearchBar(
                modifier = modifier,
                placeHolder = jsonArgs?.get("placeHolder")?.asString ?: "NULL"
            )
        },
        "TopAppBar" to { modifier, jsonArgs ->
            TopAppBar(
                modifier = modifier,
                page = jsonArgs?.get("page")?.asString ?: "NULL",
                onClickMenu = { /*TODO*/ },
                onClickProfile = { /*TODO*/ })
        },
//        "Image" to { modifier, jsonArgs ->
//            if(jsonArgs?.get("src") != null) {
//                val painter =
//                    rememberAsyncImagePainter(model = File(jsonArgs.get("src").asString))
//                Image(painter = painter, contentDescription = null)
//            }
//        },
        "FilterList" to { modifier, jsonArgs ->
            val items = jsonArgs?.get("items")?.asJsonArray?.map {
                Gson().fromJson(it, CoffeeFilter::class.java)
            } ?: emptyList()
            FilterList(modifier = modifier, items = items, onClick = {})
        },
        "ProductsGrid" to { modifier, jsonArgs ->
            val items = jsonArgs?.get("items")?.asJsonArray?.map {
                Gson().fromJson(it, Product::class.java)
            } ?: emptyList()
            ProductsGrid(modifier = modifier, items = items, onClick = {})
        }
    )

@Composable
fun JsonToUI(jsonObject: JsonObject) {
    if (jsonObject.has("layoutType")) {
        val layout = layoutMap[jsonObject["layoutType"]?.asString]

        layout?.invoke(Modifier) {
            jsonObject["components"]
                ?.asJsonArray
                ?.forEach { JsonToUI(jsonObject = it.asJsonObject) }
        }
    }
    if (jsonObject.has("component")) {
        val component = componentMap[jsonObject["component"]?.asString]
        component?.invoke(Modifier, jsonObject["args"]?.asJsonObject)
    }
}

@Composable
fun StatefulSearchBar(modifier: Modifier = Modifier, placeHolder: String = "Search Coffee") {
    var text by remember { mutableStateOf("") }
    SearchBar(modifier = modifier, value = text, placeHolder = placeHolder) {
        text = it
    }
}
