package com.snystudio.resepmasakanharian.config

import com.google.gson.JsonObject
import com.snystudio.resepmasakanharian.model.RecipesModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface ApiService {

//    @GET("recipes")
//    fun getRecipes(): List<RecipesModel>

    @GET("recipes")
    fun getRecipes(): Call<JsonObject>

}