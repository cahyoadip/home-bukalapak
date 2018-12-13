package com.adi.home.model

data class ResponsePopularProduct(
    val message: Any,
    val populars: List<Popular>,
    val status: String
)