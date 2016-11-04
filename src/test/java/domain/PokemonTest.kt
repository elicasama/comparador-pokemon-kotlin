package domain

import helpers.PokemonCreator
import org.junit.Assert.assertEquals
import org.junit.Test

class PokemonTest {
    @Test
    fun getTotalStat() {
        val pokemon = PokemonCreator().crearPokemon(0, "", 0, listOf(1.4, 5.6))
        assertEquals(7.0, pokemon.getTotalStat(), 0.0)
    }
}