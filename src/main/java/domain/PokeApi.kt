package domain


import retrofit2.Call
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API JSON de Pokemon hosteada en http://pokeapi.co.
 */
interface PokeApi{

    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<Pokemon>

    // Dentro del companion object se declaran todos los métodos de clase
    companion object {
        fun new(): PokeApi {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(PokeApi::class.java)
        }
    }

}
