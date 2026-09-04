// ST10452404 OPSC6312 ICE TASK 1
package com.example.centralink

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * RETROFIT SINGLETON: Provides a single instance of Retrofit throughout the app
 */
object RetrofitInstance {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
