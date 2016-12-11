package domain

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

/**
 * API JSON de Pokemon hosteada en http://pokeapi.co
 */
interface PokeApi{
    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<Pokemon>

    companion object {
        fun new(): PokeApi {
            val retrofit = Retrofit.Builder()m
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(PokeApi::class.java)
        }
    }
}
