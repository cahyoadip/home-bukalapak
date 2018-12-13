package com.adi.home.model

data class ResponseCategories(
    val categories: List<Category>,
    val message: Any,
    val status: String
)