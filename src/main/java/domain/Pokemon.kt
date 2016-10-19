package domain

import java.util.*

/**
 * Modelado de un [Pokemon]
 * Permite calcular la estadística total de un pokemon
 */
class Pokemon () {
    var id = 0
    lateinit var name: String
    var base_experience = 0
    lateinit var stats: ArrayList<Stat>

    /**
     * Devuelve el total de estadísticas del [pokemon]
     */
    fun getTotalStat(): Double {
        return this.stats.sumByDouble { it.base_stat }
    }
}