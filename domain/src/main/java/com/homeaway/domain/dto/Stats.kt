package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Stats(@Json(name = "lowest_price") var lowestPrice: Any? = null,
                 @Json(name = "lowest_price_good_deals") var lowestPriceGoodDeals: Any? = null,
                 @Json(name = "listing_count") var listingCount: Any? = null,
                 @Json(name = "average_price") var averagePrice: Any? = null,
                 @Json(name = "highest_price") var highestPrice: Any? = null)
