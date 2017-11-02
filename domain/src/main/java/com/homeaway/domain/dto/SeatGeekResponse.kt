package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName

data class SeatGeekResponse(@SerializedName("meta") var meta: Meta,
                            @SerializedName("in_hand") var inHand: InHand,
                            @SerializedName("events") var events: List<Event>)
