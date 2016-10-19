package domain

/**
 * Recibe los nombres de los pokemons a comparar.
 * Permite comparar 2 pokemon por distintos criterios.
 */
class PokemonComparator (poke1Name: String, poke2Name: String) {
    private val pokedex = PokedexOffline()
    private val poke1 = pokedex.getPokemonByName(poke1Name)
    private val poke2 = pokedex.getPokemonByName(poke2Name)

    /**
     * Compara al [Pokemon] según su base de experiencia
     */
    fun byBaseExperience(): Pokemon {
        if (this.poke1.base_experience >= this.poke2.base_experience)
            return this.poke1
        else {
            return this.poke2
        }
    }

    /**
     * Compara al [Pokemon] según su estadística total.
     */
    fun byTotalStat(): Pokemon {
        if (this.poke1.getTotalStat() >= this.poke2.getTotalStat())
            return this.poke1
        else
            return this.poke2
    }
}