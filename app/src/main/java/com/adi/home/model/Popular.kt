package com.adi.home.model

data class Popular(
    val campaign_id: Int,
    val icon_url: String,
    val products: List<Product>,
    val title: String
)