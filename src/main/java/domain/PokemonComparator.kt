package domain

import domain.Pokemon

/**
 * La clase recibe los nombres de los [pokemon] a comparar
 * Permite comparar 2 pokemon por los siguientes criterios:
 * ---> byBaseExperience
 * ---> byTotalStat
 */
class PokemonComparator (poke1Name: String, poke2Name: String) {
    val poke1 = PokedexOffline().getPokemonByName(poke1Name)
    val poke2 = PokedexOffline().getPokemonByName(poke2Name)

    /**
     * Compara al [pokemon] según su base de experiencia
     */
    fun byBaseExperience(): Pokemon {
        if (this.poke1.base_experience >= this.poke2.base_experience)
            return poke1
        else
            return poke2
    }

    /**
     * Compara al [pokemon] según su estadística total
     */
    fun byTotalStat(): Pokemon {
        if (Pokemon().getTotalStat(this.poke1) >= Pokemon().getTotalStat(this.poke2))
            return poke1
        else
            return poke2
    }
}