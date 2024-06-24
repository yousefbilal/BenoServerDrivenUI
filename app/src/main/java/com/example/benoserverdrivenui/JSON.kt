package com.example.benoserverdrivenui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject

//@Composable
//fun Modifier.paddingFromJson(jsonArgs: JsonObject?): Modifier {
//    return this.padding(
//        top = jsonArgs?.get("paddingTop")?.asInt?.dp ?: 0.dp,
//        start = jsonArgs?.get("paddingStart")?.asInt?.dp ?: 0.dp,
//        bottom = jsonArgs?.get("paddingBottom")?.asInt?.dp ?: 0.dp,
//        end = jsonArgs?.get("paddingEnd")?.asInt?.dp ?: 0.dp
//    )
//}

fun JsonArray.toModifier(): Modifier {
    var modifier: Modifier = Modifier
    for (i in 0 until this.size()) {
        val modifierObject = this[i].asJsonObject
        when (modifierObject["type"].asString) {
            "fillMaxSize" -> modifier = modifier.fillMaxSize()
            "padding" -> {
                val paddingValues = modifierObject["values"].asJsonObject
                val top = paddingValues["top"]?.asInt?.dp ?: 0.dp
                val start = paddingValues["start"]?.asInt?.dp ?: 0.dp
                val bottom = paddingValues["bottom"]?.asInt?.dp ?: 0.dp
                val end = paddingValues["end"]?.asInt?.dp ?: 0.dp
                modifier = modifier.padding(start, top, end, bottom)
            }

            "statusBarsPadding" -> modifier = modifier.statusBarsPadding()
            "background" -> modifier =
                modifier.background(Color(modifierObject["color"].asString.toLong(16)))
            // Add more modifier types as needed
        }
    }
    return modifier
}

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
        },
//        "NavBar" to { modifier, jsonArgs ->
//            NavBar(
//                modifier = modifier,
//                defaultSate = jsonArgs?.get("defaultState")?.asInt ?: 0,
//                onClick = {})
//
//        }
    )

@Composable
fun JsonToUI(jsonObject: JsonObject) {
    val modifier =
        if (jsonObject.has("modifier"))
            jsonObject["modifier"].asJsonArray.toModifier()
        else Modifier

    if (jsonObject.has("layoutType")) {
        val layout = layoutMap[jsonObject["layoutType"]?.asString]

        layout?.invoke(modifier) {
            jsonObject["components"]
                ?.asJsonArray
                ?.forEach { JsonToUI(jsonObject = it.asJsonObject) }
        }
    }
    if (jsonObject.has("component")) {
        val component = componentMap[jsonObject["component"]?.asString]
        component?.invoke(modifier, jsonObject["args"]?.asJsonObject)
    }
}

@Composable
fun StatefulSearchBar(modifier: Modifier = Modifier, placeHolder: String = "Search Coffee") {
    var text by remember { mutableStateOf("") }
    SearchBar(modifier = modifier, value = text, placeHolder = placeHolder) {
        text = it
    }
}
