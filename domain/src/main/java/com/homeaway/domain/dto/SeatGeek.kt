package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class SeatGeek(@Json(name = "meta") var meta: Meta? = null,
                    @Json(name = "in_hand") var inHand: InHand? = null,
                    @Json(name = "events") var events: List<Event>? = null)
