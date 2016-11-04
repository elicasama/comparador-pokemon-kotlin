package helpers

import domain.Pokemon
import domain.Stat

class PokemonCreator {

    fun crearPokemon(id: Int, name: String, baseExperience: Int, baseStats: List<Double>) : Pokemon {
        val pokemon = Pokemon()
        pokemon.id = id
        pokemon.name = name
        pokemon.base_experience = baseExperience

        pokemon.stats = baseStats.map { base ->
            val stat = Stat()
            stat.base_stat = base
            return@map stat
        }
        return pokemon
    }

}