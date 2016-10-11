package domain

import domain.Pokemon
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.FileReader

/**
 * Clase que se utiliza para evitar acceder a la api online
 */
class PokedexOffline()  {
    val gson = Gson()

    /**
     * Dado un [pokemonName] busca el archivo JSON y retorna un pokemon
     */
    fun getPokemonByName(pokemonName: String): Pokemon {
        var pokemonBuffer = BufferedReader(FileReader("./src/main/java/JSON/$pokemonName.json"))
        var pokemonParseado = gson.fromJson(pokemonBuffer, Pokemon::class.java)
        return pokemonParseado
    }

    /**
     * Devuelve el total de estadísticas del [pokemon]
     */
    fun getTotalStat(pokemon: Pokemon): Double {
         return pokemon.stats.sumByDouble { it.base_stat }
    }
}

