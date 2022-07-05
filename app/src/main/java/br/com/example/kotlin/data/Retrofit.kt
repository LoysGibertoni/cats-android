package br.com.example.kotlin.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val Retrofit: Retrofit = retrofit2.Retrofit.Builder()
    .baseUrl("https://api.thecatapi.com/v1/")
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .build()