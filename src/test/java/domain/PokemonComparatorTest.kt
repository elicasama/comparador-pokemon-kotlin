package domain

import exceptions.SinSuficientesPokemon
import helpers.PokemonCreator
import org.junit.Test
import org.unitils.reflectionassert.ReflectionAssert

class PokemonComparatorTest {

    private val pokemonCreator = PokemonCreator()
    private val poke1 = this.pokemonCreator.crearPokemon(100, "rodri", 121, listOf(45.0, 65.0))
    private val poke2 = this.pokemonCreator.crearPokemon(30, "choco", 120, listOf(30.0, 8.0))
    private val poke3 = this.pokemonCreator.crearPokemon(5, "luna", 20, listOf(50.0, 90.0))

    private val pokemons = listOf<Pokemon>(poke1, poke2, poke3)
    private val pocosPoke = listOf<Pokemon>(poke1)

    @Test
    fun byBaseExperience_compara_a_rodri_121_con_choco_120_Luna_20_gana_rodri() {
        ReflectionAssert.assertReflectionEquals(
                this.poke1,
                PokemonComparator(pokemons).byBaseExperience()
        )
    }

    @Test
    fun byTotalStat_comparar_a_rodri_110_choco_38_luna_140_gana_choco() {
        ReflectionAssert.assertReflectionEquals(
                this.poke3,
                PokemonComparator(pokemons).byTotalStat()
        )
    }

    @Test
    fun byCanon_comparamos_por_Id_rodri_100_choco_30_luna_5_gana_rodri() {
        ReflectionAssert.assertReflectionEquals(
                this.poke1,
                PokemonComparator(pokemons).byCanon {poke -> poke.id.toDouble()}
        )

    }


/*  @Test
    fun byBaseExperience_comparación_pocos_pokes_tirar_exception() {
        if(pocosPoke.count() > 2){
            throw SinSuficientesPokemon()
        } else{
            ReflectionAssert.assertReflectionEquals(
                    this.poke1,
                    PokemonComparator(pocosPoke).byBaseExperience()
            )
        }
    }*/

}