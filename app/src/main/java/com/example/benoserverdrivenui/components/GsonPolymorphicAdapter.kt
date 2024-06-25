package com.example.benoserverdrivenui.components

import com.example.benoserverdrivenui.components.modifiers.BackgroundModifier
import com.example.benoserverdrivenui.components.modifiers.FillMaxHeightModifier
import com.example.benoserverdrivenui.components.modifiers.FillMaxSizeModifier
import com.example.benoserverdrivenui.components.modifiers.FillMaxWidthModifier
import com.example.benoserverdrivenui.components.modifiers.PaddingModifier
import com.example.benoserverdrivenui.components.modifiers.SduiModifier
import com.example.benoserverdrivenui.components.modifiers.StatusBarsPaddingModifier
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory

class ComponentPolymorphicAdapter {
    private val componentAdapterFactory = RuntimeTypeAdapterFactory
        .of(Component::class.java, "type")
        .registerSubtype(BoxContainer::class.java, "box-container")
        .registerSubtype(ColumnContainer::class.java, "column")
        .registerSubtype(RowContainer::class.java, "row")
        .registerSubtype(FilterList::class.java, "filter-list")
        .registerSubtype(ProductsGrid::class.java, "products-grid")
        .registerSubtype(SearchBar::class.java, "search-bar")
        .registerSubtype(TopAppBar::class.java, "top-app-bar")
        .registerSubtype(Box::class.java, "box")

    private val modifierAdapterFactory = RuntimeTypeAdapterFactory
        .of(SduiModifier::class.java, "type")
        .registerSubtype(BackgroundModifier::class.java, "background")
        .registerSubtype(FillMaxSizeModifier::class.java, "fillMaxSize")
        .registerSubtype(FillMaxWidthModifier::class.java, "fillMaxWidth")
        .registerSubtype(FillMaxHeightModifier::class.java, "fillMaxHeight")
        .registerSubtype(PaddingModifier::class.java, "padding")
        .registerSubtype(StatusBarsPaddingModifier::class.java, "statusBarsPadding")

    fun getGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapterFactory(componentAdapterFactory)
            .registerTypeAdapterFactory(modifierAdapterFactory)
            .create()
    }
}