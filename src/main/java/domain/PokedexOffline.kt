package domain

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.FileReader

/**
 * Retorna un [Pokemon] dado el pokemonName.
 */
class PokedexOffline()  {
    private val gson = Gson()

    /**
     * Retorna un [Pokemon] dado el pokemonName.
     */
    fun getPokemonByName(pokemonName: String): Pokemon {
        val pokemonBuffer = BufferedReader(FileReader("./src/main/java/JSON/$pokemonName.json"))
        val pokemonParseado = gson.fromJson(pokemonBuffer, Pokemon::class.java)
        return pokemonParseado
    }
}
