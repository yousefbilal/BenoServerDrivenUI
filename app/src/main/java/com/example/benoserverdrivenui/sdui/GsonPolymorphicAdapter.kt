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

class PolymorphicAdapter {
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
        .registerSubtype(LazyRow::class.java, "lazy-row")
        .registerSubtype(Image::class.java, "image")
        .registerSubtype(LazyColumn::class.java, "lazy-column")
        .registerSubtype(Text::class.java, "text")
        .registerSubtype(Button::class.java, "button")
        .registerSubtype(Icon::class.java, "icon")

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