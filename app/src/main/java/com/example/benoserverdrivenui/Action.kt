package com.example.benoserverdrivenui

sealed class Action {
    data class Buy(val product: Product): Action()
}