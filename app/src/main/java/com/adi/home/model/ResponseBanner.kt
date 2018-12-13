package com.adi.home.model

data class ResponseBanner(
    val banners: List<Banner>,
    val message: Any,
    val status: String
)