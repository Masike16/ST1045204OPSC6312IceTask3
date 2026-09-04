// ST10452404 OPSC6312 ICE TASK 1
package com.example.centralink

import com.google.gson.annotations.SerializedName

/**
 * DATA MODEL: Represents a JSON object from the Web Service (JSONPlaceholder API)
 */
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    @SerializedName("body")
    val content: String
)