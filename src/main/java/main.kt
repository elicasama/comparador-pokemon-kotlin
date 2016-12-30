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
    val pokemons = pokedex.getPokemonsByNames(CLI().getPokemonNames())
    val comparator = PokemonComparator(pokemons)

    println("--------------------------------------------------------------------------")
    print("Los criterios para compararlos son: \n")
    println("--------------------------------------------------------------------------")
    PokemonComparator(pokemons).availableCanons().forEach(::println)
    println("\n")
    println("Por favor introduzca introduzca el criterio de evaluación")
    println("Presione ENTER para terminar")
    println("--------------------------------------------------------------------------")

    val inputCriterioDelUsuario = CLI().getConsoleEntry()
    println("\n")
    println("--------------------------------------------------------------------------")
    val pokeGanador = comparator.useKnownCanon(inputCriterioDelUsuario)
    println("El ganador es: \n ---> ${pokeGanador.name}")
    println("--------------------------------------------------------------------------")

    return

}