package com.example.packers.data.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RetrofitInstance @Inject constructor(
    private val baseUrl: String,
    private val moshi: Moshi,
) {

    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}