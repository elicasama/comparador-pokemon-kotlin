package domain

import com.sun.org.glassfish.external.statistics.Stats
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by rodri042 on 10/28/16.
 */
class PokemonTest {
    @Test
    fun getTotalStat() {
        val pokemon = Pokemon()
        val stat1 = Stat()
        val stat2 = Stat()
        stat1.base_stat = 1.4
        stat2.base_stat = 5.6
        pokemon.stats = listOf<Stat>(stat1, stat2)
        assertEquals(7,7)
    }
}