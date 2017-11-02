package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Stats(@Json(name = "lowest_price") var lowestPrice: Any,
                 @Json(name = "lowest_price_good_deals") var lowestPriceGoodDeals: Any,
                 @Json(name = "listing_count") var listingCount: Any,
                 @Json(name = "average_price") var averagePrice: Any,
                 @Json(name = "highest_price") var highestPrice: Any)
