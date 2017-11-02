package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Taxonomy(@Json(name = "name") var name: String,
                    @Json(name = "parent_id") var parentId: Any,
                    @Json(name = "id") var id: Int)
