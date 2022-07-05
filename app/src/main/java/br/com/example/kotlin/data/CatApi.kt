package br.com.example.kotlin.data

import retrofit2.http.GET
import retrofit2.http.Headers

interface CatApi {

    @Headers("x-api-key: ADICIONAR KEY AQUI")
    @GET("breeds")
    suspend fun getBreeds(): List<CatBreed>
}