package domain

import helpers.PokemonCreator
import org.junit.Test
import org.unitils.reflectionassert.ReflectionAssert

class PokedexOfflineTest {
    private val pokedex = PokedexOffline("./src/test/java/JSON")
    private val pokemonCreator = PokemonCreator()
    private val poke1 = this.pokemonCreator.crearPokemon(100, "rodri", 121, listOf(45.0, 65.0))
    private val poke2 = this.pokemonCreator.crearPokemon(30, "choco", 120, listOf(30.0, 8.0))

    @Test
    fun getPokemonByName_retorna_el_pokemon_parseado_de_la_carpeta() {
        ReflectionAssert.assertReflectionEquals(
            this.poke1,
            pokedex.getPokemonByName("rodri")
        )
    }

    @Test
    fun getPokemonsByNames_retorna_una_lista_de_Pokemon() {
        ReflectionAssert.assertReflectionEquals(
            listOf(poke1, poke2),
            this.pokedex.getPokemonsByNames(listOf("rodri", "choco"))
        )
    }

}