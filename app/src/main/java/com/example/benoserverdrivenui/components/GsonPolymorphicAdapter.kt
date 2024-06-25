package com.example.benoserverdrivenui.components

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory

class ComponentPolymorphicAdapter {
    private val typeAdapterFactory = RuntimeTypeAdapterFactory
        .of(Component::class.java, "type")
        .registerSubtype(BoxContainer::class.java, "box-container")
        .registerSubtype(ColumnContainer::class.java, "column")
        .registerSubtype(RowContainer::class.java, "row")
        .registerSubtype(FilterList::class.java, "filter-list")
        .registerSubtype(ProductsGrid::class.java, "products-grid")
        .registerSubtype(SearchBar::class.java, "search-bar")
        .registerSubtype(TopAppBar::class.java, "top-app-bar")

    fun getGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapterFactory(typeAdapterFactory)
            .create()
    }
}