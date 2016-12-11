package domain

/**
 * Created by Liz on 11/12/2016.
 */
interface Pokedex {

    fun getPokemonByName(name: String): Pokemon

    /**
     * Genera una lista de [Pokemon] a partir de una lista de nombres de pokemon.
     */
    fun getPokemonsByNames(names: List<String>): List<Pokemon> {
        return names.map { name -> this.getPokemonByName(name) }
    }

}