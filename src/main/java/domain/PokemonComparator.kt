package domain

import exceptions.SinSuficientesPokemon

/**
 * Recibe un array de instancias de [Pokemon] a comparar.
 * Permite comparar a los [Pokemon] por distintos criterios.
 */
class PokemonComparator (pokemonsAComparar: List<Pokemon>) {

    private val pokemons = pokemonsAComparar

    init {
        if (this.pokemons.count() < 2)
            throw SinSuficientesPokemon()
    }

    /**
     * Compara al [Pokemon] según su experiencia base.
     */
    fun byBaseExperience() : Pokemon {
        return this.byCanon { poke -> poke.base_experience.toDouble() }
    }

    /**
     * Compara al [Pokemon] según su estadística total.
     */
    fun byTotalStat(): Pokemon {
        return this.byCanon { poke -> poke.getTotalStat() }
    }

    /**
     * Compara al [Pokemon] por un criterio.
     */
    fun byCanon(criterio: (Pokemon) -> Double): Pokemon {
        return this.pokemons.maxBy(criterio)!!
    }

}

