package domain

import exceptions.SinSuficientesPokemon
import helpers.PokemonCreator
import org.junit.Test
import org.junit.experimental.theories.DataPoint
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import org.unitils.reflectionassert.ReflectionAssert
import kotlin.test.assertFailsWith

class PokemonComparatorTest {

    private val pokemonCreator = PokemonCreator()

    private val rodri = this.pokemonCreator.crearPokemon(100, "rodri", 121, listOf(45.0, 65.0))
    private val choco = this.pokemonCreator.crearPokemon(30, "choco", 120, listOf(30.0, 8.0))
    private val luna = this.pokemonCreator.crearPokemon(5, "luna", 20, listOf(50.0, 90.0))

    private val pokemons = listOf<Pokemon>(this.rodri, this.choco, this.luna)

    @Test
    fun byBaseExperience_compara_a_rodri_121_con_choco_120_con_luna_20_gana_rodri() {
        ReflectionAssert.assertReflectionEquals(
                this.rodri,
                PokemonComparator(this.pokemons).byBaseExperience()
        )
    }

    @Test
    fun byTotalStat_compara_a_rodri_110_choco_38_luna_140_gana_choco() {
        ReflectionAssert.assertReflectionEquals(
                this.luna,
                PokemonComparator(this.pokemons).byTotalStat()
        )
    }

    @Test
    fun byCanon_compara_por_Id_rodri_100_choco_30_luna_5_gana_rodri() {
        ReflectionAssert.assertReflectionEquals(
                this.rodri,
                PokemonComparator(this.pokemons).useCustomCanon { poke -> poke.id.toDouble()}
        )
    }

}

@RunWith(Theories::class)
class CuandoHayPocosPokemonTest() {
    companion object {
        @DataPoint @JvmField
        val conNinguno = listOf<Pokemon>()

        @DataPoint @JvmField
        val conUno = listOf(Pokemon())
    }

    @Theory
    fun byBaseExperience_compara_con_pocos_pokes_tira_exception(pokemons: List<Pokemon>) {
        assertFailsWith(SinSuficientesPokemon::class, { PokemonComparator(pokemons).byBaseExperience() })
    }
}