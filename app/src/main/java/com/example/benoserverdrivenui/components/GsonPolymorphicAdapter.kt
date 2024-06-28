package com.example.benoserverdrivenui.components

import com.example.benoserverdrivenui.components.cup_screen.AddressBox
import com.example.benoserverdrivenui.components.cup_screen.Payment
import com.example.benoserverdrivenui.components.cup_screen.TopNavBar
import com.example.benoserverdrivenui.components.details_screen_components.BuyNowRow
import com.example.benoserverdrivenui.components.details_screen_components.DetailTopAppBar
import com.example.benoserverdrivenui.components.details_screen_components.ProductsDetails
import com.example.benoserverdrivenui.components.details_screen_components.SizeBox
import com.example.benoserverdrivenui.components.home_components.FilterList
import com.example.benoserverdrivenui.components.home_components.ProductsGrid
import com.example.benoserverdrivenui.components.home_components.SearchBar
import com.example.benoserverdrivenui.components.modifiers.BackgroundModifier
import com.example.benoserverdrivenui.components.modifiers.FillMaxHeightModifier
import com.example.benoserverdrivenui.components.modifiers.FillMaxSizeModifier
import com.example.benoserverdrivenui.components.modifiers.FillMaxWidthModifier
import com.example.benoserverdrivenui.components.modifiers.HeightModifier
import com.example.benoserverdrivenui.components.modifiers.PaddingModifier
import com.example.benoserverdrivenui.components.modifiers.SafeDrawingPadding
import com.example.benoserverdrivenui.components.modifiers.SduiModifier
import com.example.benoserverdrivenui.components.modifiers.SizeModifier
import com.example.benoserverdrivenui.components.modifiers.StatusBarsPaddingModifier
import com.example.benoserverdrivenui.components.modifiers.WidthModifier
import com.example.benoserverdrivenui.components.modifiers.ZIndex
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
        .registerSubtype(NavBar::class.java, "nav-bar")
        .registerSubtype(DetailTopAppBar::class.java, "detail-top-bar")
        .registerSubtype(ProductsDetails::class.java, "product-details")
        .registerSubtype(SizeBox::class.java, "size-box")
        .registerSubtype(BuyNowRow::class.java, "buy-now-row")
        .registerSubtype(AddressBox::class.java, "address-box")
        .registerSubtype(Payment::class.java, "payment")
        .registerSubtype(TopNavBar::class.java, "top-nav-bar")

    private val modifierAdapterFactory = RuntimeTypeAdapterFactory
        .of(SduiModifier::class.java, "type")
        .registerSubtype(BackgroundModifier::class.java, "background")
        .registerSubtype(FillMaxSizeModifier::class.java, "fillMaxSize")
        .registerSubtype(FillMaxWidthModifier::class.java, "fillMaxWidth")
        .registerSubtype(FillMaxHeightModifier::class.java, "fillMaxHeight")
        .registerSubtype(PaddingModifier::class.java, "padding")
        .registerSubtype(StatusBarsPaddingModifier::class.java, "statusBarsPadding")
        .registerSubtype(SafeDrawingPadding::class.java, "safeDrawingPadding")
        .registerSubtype(SizeModifier::class.java, "size")
        .registerSubtype(HeightModifier::class.java, "height")
        .registerSubtype(WidthModifier::class.java, "width")
        .registerSubtype(ZIndex::class.java, "zIndex")

    fun getGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapterFactory(componentAdapterFactory)
            .registerTypeAdapterFactory(modifierAdapterFactory)
            .create()
    }
}