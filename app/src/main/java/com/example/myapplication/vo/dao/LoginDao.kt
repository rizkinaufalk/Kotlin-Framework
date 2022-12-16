package com.example.myapplication.vo.dao

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["id"])
data class LoginDao(

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("rememberMe")
	val rememberMe: Boolean? = null,

	@field:SerializedName("username")
	val username: String? = null
)
