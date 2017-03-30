import domain.*

fun main(args: Array<String>) {
    /**
     * Selección de Pokedex
     */
    val pokedex = PokedexOffline("./src/main/java/JSON")
   // val pokedex = PokedexOnline()

    println("--------------------------------------------------------------------------")
    println("Por favor introduzca los nombres de pokemon a comparar separados por espacios")
    println("Presione ENTER para terminar")
    println("--------------------------------------------------------------------------")
    val cli = CLI()
    val pokemons = pokedex.getPokemonsByNames(cli.getPokemonNames())
    val comparator = PokemonComparator(pokemons)

    cli.startComparition(comparator)

    return
}