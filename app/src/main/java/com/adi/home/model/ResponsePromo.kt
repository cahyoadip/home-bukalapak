package com.adi.home.model

data class ResponsePromo(
    val promo_banners: List<Banner>,
    val message: Any,
    val status: String
)