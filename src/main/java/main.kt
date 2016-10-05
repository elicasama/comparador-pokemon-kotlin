import collections.PokedexOffline

fun main(args: Array<String>) {

    val pokemon = PokedexOffline().getPokemonByName("charmander")

    println("El pokemon es:  ${pokemon.name} , con id ${pokemon.id} y una experiencia de ${pokemon.base_experience}")

}