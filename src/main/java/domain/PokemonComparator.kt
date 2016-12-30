package domain

import exceptions.MetodoNoEncontrado
import exceptions.SinSuficientesPokemon
import extensions.getMethodNames
import extensions.invokeMethod
import java.lang.reflect.Method

/**
 * Recibe un array de instancias de [Pokemon] a comparar.
 * Permite comparar a los [Pokemon] por distintos criterios.
 */
class PokemonComparator(pokemonsAComparar: List<Pokemon>) {

    private val pokemons = pokemonsAComparar

    init {
        if (this.pokemons.count() < 2)
            throw SinSuficientesPokemon()
    }

    /**
     * Compara al [Pokemon] según su experiencia base.
     */
    fun byBaseExperience(): Pokemon {
        return this.useCustomCanon { poke -> poke.base_experience.toDouble() }
    }

    /**
     * Compara al [Pokemon] según su estadística total.
     */
    fun byTotalStat(): Pokemon {
        return this.useCustomCanon { poke -> poke.getTotalStat() }
    }

    /**
     * Compara al [Pokemon] según el nombre de uno de los métodos byXXX.
     */
    fun useKnownCanon(canonName: String): Pokemon {
        try {
            return this.invokeMethod<Pokemon>(canonName)
        }catch (e: java.lang.NoSuchMethodException ){
            throw MetodoNoEncontrado(e.message)
        }
    }

    /**
     * Compara al [Pokemon] por un criterio.
     */
    fun useCustomCanon(criterio: (Pokemon) -> Double): Pokemon {
        return this.pokemons.maxBy(criterio)!!
    }

    /**
     * Retorna todos los criterios conocidos.
     */
    fun availableCanons(): List<String> {
       return this.javaClass.getMethodNames().filter { it.startsWith("by") }
    }
}

