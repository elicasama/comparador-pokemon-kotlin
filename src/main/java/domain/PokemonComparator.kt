package domain

import collections.PokedexOffline
import collections.Pokemon

/**
 * La clase recibe los nombres de los pokemon a comparar
 * Permite comparar 2 pokemon por los siguientes criterios:
 * ---> byBaseExperience
 * by
 */
class PokemonComparator (poke1Name: String, poke2Name: String){
    val poke1 = PokedexOffline().getPokemonByName(poke1Name)
    val poke2 = PokedexOffline().getPokemonByName(poke2Name)


    fun byBaseExperience(): Pokemon{
        if (this.poke1.base_experience >= this.poke2.base_experience)
            return poke1
        else
            return poke2
    }

}