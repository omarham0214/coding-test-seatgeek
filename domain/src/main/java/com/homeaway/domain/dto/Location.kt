package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Location(@SerializedName("lat") var lat: Double,
                    @SerializedName("lon") var lon: Double) : Serializable
