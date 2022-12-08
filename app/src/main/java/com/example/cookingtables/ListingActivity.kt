package com.example.cookingmama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.IOException

class ListingActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)

    }

    object Recipes {
        private const val BASE_URL: String = "https://api.spoonacular.com/recipes/random?number=30"

        private val gson : Gson by lazy {
            GsonBuilder().setLenient().create()
        }

        private val httpClient : OkHttpClient by lazy {
            OkHttpClient.Builder().build()
        }

        private val retrofit : Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        val apiService :  ApiService by lazy{
            retrofit.create(ApiService::class.java)
        }
    }

    interface ApiService {
        @GET("recipes")
        suspend fun getRecipes(): Response<MutableList<Recipe>>
    }

    data class Recipe(
        val id: Int? = null,
        val title: String? = null,
        val description: String? = null
    )

        val client = OkHttpClient()

    /**
     * Envoit une requête à une API renseignée.
     *
     * @param String
     * @return API Request
     */
    private fun execute(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()
    }
}
