// ST10452404 OPSC6312 ICE TASK 1
package com.example.centralink

import retrofit2.http.GET

/**
 * WEB SERVICE INTERFACE: Defines the endpoints for the API
 */
interface ApiService {
    @GET("posts/1") // Fetch a single dummy post
    suspend fun getPost(): Post
}