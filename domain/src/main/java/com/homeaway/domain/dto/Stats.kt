package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Stats(@SerializedName("lowest_price") var lowestPrice: Any,
                 @SerializedName("lowest_price_good_deals") var lowestPriceGoodDeals: Any,
                 @SerializedName("listing_count") var listingCount: Any,
                 @SerializedName("average_price") var averagePrice: Any,
                 @SerializedName("highest_price") var highestPrice: Any) : Serializable
