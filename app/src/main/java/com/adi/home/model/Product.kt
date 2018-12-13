package com.adi.home.model

data class Product(
    val active: Boolean,
    val assurance: Boolean,
    val brand: Boolean,
    val category: String,
    val category_id: Int,
    val city: String,
    val condition: String,
    val courier: List<String>,
    val created_at: String,
    val desc: String,
    val favorited: Boolean,
    val id: String,
    val images: List<String>,
    val interest_count: Int,
    val name: String,
    val premium_account: Boolean,
    val price: Int,
    val product_sin: List<Any>,
    val product_sku: List<Any>,
    val province: String,
    val rating: Rating,
    val rush_delivery: Boolean,
    val seller_avatar: String,
    val seller_delivery_time: String,
    val seller_id: Int,
    val seller_level: String,
    val seller_level_badge_url: String,
    val seller_name: String,
    val seller_negative_feedback: Int,
    val seller_positive_feedback: Int,
    val seller_term_condition: String,
    val sold_count: Int,
    val stock: Int,
    val top_merchant: Boolean,
    val url: String,
    val view_count: Int,
    val weight: Int
)