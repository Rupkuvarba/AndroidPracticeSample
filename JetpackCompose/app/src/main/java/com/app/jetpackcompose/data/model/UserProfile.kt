package com.app.jetpackcompose.data.model

import com.app.jetpackcompose.R

data class UserProfile constructor(val name: String, val status: Boolean, val drawableId: Int)

val userProfileList = arrayListOf(
    UserProfile(name = "Krishn vasudev", status = true, R.drawable.profile_picture_1),
    UserProfile(name = "Radha Krishn", status = false, R.drawable.profile_picture_2),
)