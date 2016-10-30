package helpers

import domain.Pokemon
import domain.Stat

class PokemonCreator {

    fun crearPokemon(id: Int, name: String, baseExperience: Int, baseStats: List<Double>) : Pokemon {
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