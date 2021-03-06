package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Taxonomy(@SerializedName("name") var name: String,
                    @SerializedName("parent_id") var parentId: Any,
                    @SerializedName("id") var id: Int) : Serializable
