package domain

import java.util.*

/**
 * Recibe un array de nombres de pokemon y devuelve un array instaciados de [Pokemon]
 */
class Pokemons(nombresPokemon: ArrayList<String>){
    val nombresDePokemon = nombresPokemon
    val pokedex = PokedexOffline()

    /**
     * Genera una lista de instancias de [Pokemon] a partir de una lista de nombres de pokemon
     */
    fun crearPokemons () : List<Pokemon> {
        return  this.nombresDePokemon.map ({pokedex.getPokemonByName(it) })
    }
}