package domain

import java.util.*

/**
 * Recibe un array de instancias de [Pokemon] a comparar.
 * Permite comparar a los [Pokemon] por distintos criterios.
 */
class PokemonComparator ( pokemonsAComparar: ArrayList<Pokemon>) {
    private val pokemons = pokemonsAComparar
    /**
     * TODO: Sigue existiendo lógica repetida, analizar pasar el criterio por parametro
     */

    /**
     * Compara al [Pokemon] según su base de experiencia
     */
    fun byBaseExperience() : Pokemon? {
        return this.pokemons.maxBy { it.base_experience }

    }

    /**
     * Compara al [Pokemon] según su estadística total.
     */
    fun byTotalStat(): Pokemon? {
        return this.pokemons.maxBy { it.getTotalStat() }
    }
}

