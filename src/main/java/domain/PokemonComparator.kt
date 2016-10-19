package domain

/**
 * Recibe las instancias de [Pokemon] a comparar.
 * Permite comparar 2 pokemon por distintos criterios.
 */
class PokemonComparator (poke1: Pokemon, poke2: Pokemon) {
    private val poke1 = poke1
    private val poke2 = poke2

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