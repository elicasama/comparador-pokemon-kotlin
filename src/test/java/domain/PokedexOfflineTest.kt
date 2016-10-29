package domain

import org.junit.Test
import org.unitils.reflectionassert.ReflectionAssert
import kotlin.test.assertTrue

/**
 *
 */
class PokedexOfflineTest {
    private val pokedex = PokedexOffline("./src/test/java/JSON")
    private val poke1 = Pokemon()
    private val poke2 = Pokemon()
    private val pokemonNames = listOf<String>("rodri", "choco")
    private val pokemons = listOf<Pokemon>(poke1, poke2)

    init {
        val stat1Poke1 = Stat()
        val stat2Poke1 = Stat()
        val stat1Poke2 = Stat()
        val stat2Poke2 = Stat()

        poke1.id = 100
        poke1.name = "rodri"
        poke1.base_experience = 121
        stat1Poke1.base_stat = 45.0
        stat2Poke1.base_stat = 65.0
        poke1.stats = listOf<Stat>(stat1Poke1, stat2Poke1)

        poke2.id = 30
        poke2.name = "choco"
        poke2.base_experience = 120
        stat1Poke2.base_stat = 3.4
        stat2Poke2.base_stat = 1.6
        poke2.stats = listOf<Stat>(stat1Poke2, stat2Poke2)

    }
    /**
     * Probando el método [getPokemonByName]
     */
    @Test
    fun getPokemonByName_retorna_el_pokemon_parseado_de_la_carpeta() {
        ReflectionAssert.assertReflectionEquals(this.poke1, pokedex.getPokemonByName("rodri"));
    }

//    /**
//     * Probando el método [getPokemonByNames]
//     */
//
//    @Test
//    fun getPokemonByNames() {excludeFields
//        assertEquals(pokedex.getPokemonByNames(pokemonNames), pokemons)
//    }
}