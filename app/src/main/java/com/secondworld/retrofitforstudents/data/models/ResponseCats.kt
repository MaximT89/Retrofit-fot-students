package com.secondworld.retrofitforstudents.data.models

import com.google.gson.annotations.SerializedName

data class ResponseCats(

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null
)
