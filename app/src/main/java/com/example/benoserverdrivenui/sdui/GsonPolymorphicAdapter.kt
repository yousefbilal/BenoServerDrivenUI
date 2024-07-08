package com.example.benoserverdrivenui.sdui

import com.example.benoserverdrivenui.Screen
import com.example.benoserverdrivenui.sdui.actions.NavigationAction
import com.example.benoserverdrivenui.sdui.actions.SduiAction
import com.example.benoserverdrivenui.sdui.actions.ToastAction
import com.example.benoserverdrivenui.sdui.actions.WebLinkAction
import com.example.benoserverdrivenui.sdui.actions.WhatsAppAction
import com.example.benoserverdrivenui.sdui.components.Component
import com.example.benoserverdrivenui.sdui.components.Image
import com.example.benoserverdrivenui.sdui.components.NavBar
import com.example.benoserverdrivenui.sdui.components.TopAppBar
import com.example.benoserverdrivenui.sdui.components.cup_screen.AddressBox
import com.example.benoserverdrivenui.sdui.components.cup_screen.Payment
import com.example.benoserverdrivenui.sdui.components.cup_screen.TopNavBar
import com.example.benoserverdrivenui.sdui.components.details_screen.BuyNowRow
import com.example.benoserverdrivenui.sdui.components.details_screen.DetailTopAppBar
import com.example.benoserverdrivenui.sdui.components.details_screen.ProductsDetails
import com.example.benoserverdrivenui.sdui.components.details_screen.SizeBox
import com.example.benoserverdrivenui.sdui.components.home_screen.FilterList
import com.example.benoserverdrivenui.sdui.components.home_screen.ProductsGrid
import com.example.benoserverdrivenui.sdui.components.home_screen.SearchBar
import com.example.benoserverdrivenui.sdui.components.primitive.Box
import com.example.benoserverdrivenui.sdui.components.primitive.BoxContainer
import com.example.benoserverdrivenui.sdui.components.primitive.Button
import com.example.benoserverdrivenui.sdui.components.primitive.ColumnContainer
import com.example.benoserverdrivenui.sdui.components.primitive.Icon
import com.example.benoserverdrivenui.sdui.components.primitive.LazyColumn
import com.example.benoserverdrivenui.sdui.components.primitive.LazyRow
import com.example.benoserverdrivenui.sdui.components.primitive.RowContainer
import com.example.benoserverdrivenui.sdui.components.primitive.Text
import com.example.benoserverdrivenui.sdui.modifiers.BackgroundModifier
import com.example.benoserverdrivenui.sdui.modifiers.FillMaxHeightModifier
import com.example.benoserverdrivenui.sdui.modifiers.FillMaxSizeModifier
import com.example.benoserverdrivenui.sdui.modifiers.FillMaxWidthModifier
import com.example.benoserverdrivenui.sdui.modifiers.HeightModifier
import com.example.benoserverdrivenui.sdui.modifiers.PaddingModifier
import com.example.benoserverdrivenui.sdui.modifiers.SafeDrawingPadding
import com.example.benoserverdrivenui.sdui.modifiers.SduiModifier
import com.example.benoserverdrivenui.sdui.modifiers.SizeModifier
import com.example.benoserverdrivenui.sdui.modifiers.StatusBarsPaddingModifier
import com.example.benoserverdrivenui.sdui.modifiers.WidthModifier
import com.example.benoserverdrivenui.sdui.modifiers.ZIndex
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory

val componentMapping = mapOf(
    BoxContainer::class.java to "box-container",
    ColumnContainer::class.java to "column",
    RowContainer::class.java to "row",
    FilterList::class.java to "filter-list",
    ProductsGrid::class.java to "products-grid",
    SearchBar::class.java to "search-bar",
    TopAppBar::class.java to "top-app-bar",
    Box::class.java to "box",
    NavBar::class.java to "nav-bar",
    DetailTopAppBar::class.java to "detail-top-bar",
    ProductsDetails::class.java to "product-details",
    SizeBox::class.java to "size-box",
    BuyNowRow::class.java to "buy-now-row",
    AddressBox::class.java to "address-box",
    Payment::class.java to "payment",
    TopNavBar::class.java to "top-nav-bar",
    LazyRow::class.java to "lazy-row",
    Image::class.java to "image",
    LazyColumn::class.java to "lazy-column",
    Text::class.java to "text",
    Button::class.java to "button",
    Icon::class.java to "icon"
)

val modifierMapping = mapOf(
    BackgroundModifier::class.java to "background",
    FillMaxSizeModifier::class.java to "fillMaxSize",
    FillMaxWidthModifier::class.java to "fillMaxWidth",
    FillMaxHeightModifier::class.java to "fillMaxHeight",
    PaddingModifier::class.java to "padding",
    StatusBarsPaddingModifier::class.java to "statusBarsPadding",
    SafeDrawingPadding::class.java to "safeDrawingPadding",
    SizeModifier::class.java to "size",
    HeightModifier::class.java to "height",
    WidthModifier::class.java to "width",
    ZIndex::class.java to "zIndex"
)

class PolymorphicAdapter {
    private val componentAdapterFactory = RuntimeTypeAdapterFactory
        .of(Component::class.java, "type")
        .apply {
            componentMapping.forEach { (clazz, type) ->
                registerSubtype(clazz, type)
            }
        }

    private val modifierAdapterFactory = RuntimeTypeAdapterFactory
        .of(SduiModifier::class.java, "type")
        .apply {
            modifierMapping.forEach { (clazz, type) ->
                registerSubtype(clazz, type)
            }
        }

    private val screenAdapterFactory = RuntimeTypeAdapterFactory
        .of(Screen::class.java, "type")
        .registerSubtype(Screen.Home::class.java, "home")
        .registerSubtype(Screen.Details::class.java, "details")
        .registerSubtype(Screen.Cup::class.java, "cup")
        .registerSubtype(Screen.Favorite::class.java, "favorite")
        .registerSubtype(Screen.Notification::class.java, "notification")

    private val actionAdapterFactory = RuntimeTypeAdapterFactory
        .of(SduiAction::class.java, "type")
        .registerSubtype(ToastAction::class.java, "toast")
        .registerSubtype(NavigationAction::class.java, "navigation")
        .registerSubtype(WebLinkAction::class.java, "web-link")
        .registerSubtype(WhatsAppAction::class.java, "whatsapp")

    fun getGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapterFactory(componentAdapterFactory)
            .registerTypeAdapterFactory(modifierAdapterFactory)
            .registerTypeAdapterFactory(screenAdapterFactory)
            .registerTypeAdapterFactory(actionAdapterFactory)
            .create()
    }
}