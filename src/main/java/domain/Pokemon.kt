package domain

import java.util.*

/**
 * Clase Pokemon, se va a instanciar con un JSON
 */
class Pokemon () {
    var id = 0
    lateinit var name: String
    var base_experience = 0
    lateinit var stats: ArrayList<Stat>

    /**
     * Devuelve el total de estadísticas del [pokemon]
     */
    fun getTotalStat(pokemon: Pokemon): Double {
        return pokemon.stats.sumByDouble { it.base_stat }
    }
}