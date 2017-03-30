package domain.cli

import domain.Pokemon
import domain.PokemonComparator

class KnownCanon(private val name: String) : Canon {
    override fun run(comparator: PokemonComparator): Pokemon {
        return comparator.useKnownCanon(this.name)
    }
}