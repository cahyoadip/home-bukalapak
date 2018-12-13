package com.adi.home.model

data class Category(
    val children: List<Children>,
    val id: Int,
    val name: String,
    val revamped: Boolean,
    val url: String
)