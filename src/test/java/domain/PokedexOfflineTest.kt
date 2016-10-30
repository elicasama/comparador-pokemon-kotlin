package domain

import org.junit.Test
import org.unitils.reflectionassert.ReflectionAssert

class PokedexOfflineTest {
    private val pokedex = PokedexOffline("./src/test/java/JSON")
    private val poke1 = crearPokemon(100, "rodri", 121, listOf(45.0, 65.0))
    private val poke2 = crearPokemon(30, "choco", 120, listOf(30.0, 8.0))

    @Test
    fun getPokemonByName_retorna_el_pokemon_parseado_de_la_carpeta() {
        ReflectionAssert.assertReflectionEquals(
            this.poke1,
            pokedex.getPokemonByName("rodri")
        )
    }

    @Test
    fun getPokemonByNames_retorna_una_lista_de_Pokemon() {
        ReflectionAssert.assertReflectionEquals(
            listOf(poke1, poke2),
            this.pokedex.getPokemonByNames(listOf("rodri", "choco"))
        )
    }

    private fun crearPokemon(id: Int, name: String, baseExperience: Int, baseStats: List<Double>) : Pokemon {
        val poke = Pokemon()
        poke.id = id
        poke.name = name
        poke.base_experience = baseExperience

        poke.stats = baseStats.map { base ->
            val stat = Stat()
            stat.base_stat = base
            return@map stat
        }
        return poke
    }

}