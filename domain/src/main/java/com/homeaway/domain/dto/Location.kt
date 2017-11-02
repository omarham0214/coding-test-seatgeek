package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("lat") var lat: Double,
                    @SerializedName("lon") var lon: Double)
