package domain

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

//"https://pokeapi.co/api/v2/pokemon/1/"

interface PokeApi {
    @GET("pokemon/{name}")
    fun getByName(@Path("name") name: String): Call<Pokemon>
}

object PruebaHTTP {
    @JvmStatic fun main(args: Array<String>) {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val pokeApi = retrofit.create(PokeApi::class.java)

        val pikachu = pokeApi.getByName("pikachu").execute().body()
        println(Gson().toJson(pikachu))
    }
}
