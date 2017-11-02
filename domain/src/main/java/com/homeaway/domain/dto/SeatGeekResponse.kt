package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class SeatGeekResponse(@Json(name = "meta") var meta: Meta,
                            @Json(name = "in_hand") var inHand: InHand,
                            @Json(name = "events") var events: List<Event>)
