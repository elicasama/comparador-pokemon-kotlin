import collections.PokedexOffline
import domain.PokemonComparator

fun main(args: Array<String>) {

    val pokemon = PokedexOffline().getPokemonByName("charmander")

    println("El pokemon es:  ${pokemon.name} , con id ${pokemon.id} y una experiencia de ${pokemon.base_experience}")

    val superPoke = PokemonComparator("kakuna","charmander").byBaseExperience()

    println("El ganador por base de experiencia es: ${superPoke.name} con ${superPoke.base_experience}")
}