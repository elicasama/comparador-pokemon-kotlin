package domain.cli

import domain.CriterioBuilder
import domain.Pokemon
import domain.PokemonComparator

class CustomCanon(private val jsFunction: String) : Canon {
    override fun run(comparator: PokemonComparator): Pokemon {
        val canon = CriterioBuilder.byUserInput(this.jsFunction)
        return comparator.useCustomCanon(canon)
    }
}