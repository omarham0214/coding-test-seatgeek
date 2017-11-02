package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Meta(@SerializedName("per_page") var perPage: Int,
                @SerializedName("page") var page: Int,
                @SerializedName("geolocation") var geolocation: Any,
                @SerializedName("took") var took: Int,
                @SerializedName("total") var total: Int) : Serializable
