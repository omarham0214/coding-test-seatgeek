package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Images(@SerializedName("huge") var huge: String) : Serializable
