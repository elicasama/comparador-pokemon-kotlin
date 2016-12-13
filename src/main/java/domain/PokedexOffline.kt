package domain

import com.google.gson.Gson
import exceptions.PokemonNoEncontrado
import java.io.BufferedReader
import java.io.FileReader

/**
 * Brinda información de los Pokemon de manera offline.
 */
class PokedexOffline(private val path: String) : Pokedex  {

    private val gson = Gson()

    /**
     * Retorna un [Pokemon] dado el [name].
     */
        override fun getPokemonByName(name: String): Pokemon {
            try{
                val pokemonBuffer = BufferedReader(FileReader("$path/$name.json"))
                val pokemonParseado = gson.fromJson(pokemonBuffer, Pokemon::class.java)
                return pokemonParseado
            } catch (e: java.io.FileNotFoundException) {
                throw PokemonNoEncontrado()
            }
        }

}
