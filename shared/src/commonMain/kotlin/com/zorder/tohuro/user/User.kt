package com.zorder.tohuro.user

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val age: Int
)