package domain

import java.util.*

/**
 * Modelado de un [Pokemon]
 */
class Pokemon () {
    var id = 0
    lateinit var name: String
    var base_experience = 0
    lateinit var stats: List<Stat>

    /**
     * Devuelve el total de estadísticas del [Pokemon]
     */
    fun getTotalStat(): Double {
        return this.stats.sumByDouble { it.base_stat }
    }
}