package domain.cli

import domain.Pokemon
import domain.PokemonComparator

interface Canon {
    fun run(comparator: PokemonComparator): Pokemon
}
