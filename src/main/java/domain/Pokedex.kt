package domain

/**
 * Permite agrupar de manera abstracta las PokedexdexOnline y PokedexOffline.
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