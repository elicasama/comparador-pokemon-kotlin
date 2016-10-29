package domain

import org.junit.Assert.assertEquals
import org.junit.Test

class PokemonTest {
    @Test
    fun getTotalStat() {
        val pokemon = Pokemon()
        val stat1 = Stat()
        val stat2 = Stat()

        stat1.base_stat = 1.4
        stat2.base_stat = 5.6
        pokemon.stats = listOf<Stat>(stat1, stat2)

        assertEquals(7.0, pokemon.getTotalStat(), 0.0)
    }
}