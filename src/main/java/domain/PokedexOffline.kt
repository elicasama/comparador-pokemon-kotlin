package domain

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.FileReader

/**
 * Brinda información de los Pokemon de manera offline
 */
class PokedexOffline() : Pokedex {

    private val gson = Gson()

    /**
     * Retorna un [Pokemon] dado el [name].
     */
    override fun getPokemonByName(name: String): Pokemon {
        val pokemonBuffer = BufferedReader(FileReader("./src/main/java/JSON/$name.json"))
        val pokemonParseado = gson.fromJson(pokemonBuffer, Pokemon::class.java)
        return pokemonParseado
    }

}
