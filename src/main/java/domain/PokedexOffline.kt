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
     * Dado un pokedexParseado busca el archivo JSON y retorna el pokemon que coincide.
     */
    fun getPokemonByName(pokemonName: String): Pokemon {
        var pokemonBuffer = BufferedReader(FileReader("./src/main/java/JSON/$pokemonName.json"))
        var pokemonParseado = gson.fromJson(pokemonBuffer, Pokemon::class.java)
        return pokemonParseado
    }
}
