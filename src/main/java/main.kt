import domain.*
import extensions.getMethodNames

fun main(args: Array<String>) {
    /**
     * Selección de Pokedex
     */
    val pokedex = PokedexOffline("./src/main/java/JSON")
   // val pokedex = PokedexOnline()

    /**
     * Ingreso de nombres por parte del usuario
     */
    val pokemons = pokedex.getPokemonsByNames(CLI().getPokemonNames())
    val inputCriterioDelUsuario = CLI().getCriterio()
    // PokemonComparator(pokemons).availableCanons().forEach(::println)

    val comparator = PokemonComparator(pokemons)
    val pokeGanador = comparator.useKnownCanon("byBaseExperience")

    println("El ganador es ${pokeGanador.name}")
    return

    /**
     * Presentación de los participantes
     */
    println("--------------------------------------------------------------------------")
    println("Los participantes son:")
    println("--------------------------------------------------------------------------")
    pokemons.forEach {
        poke -> println("${poke.name} " +
            "con Id: ${poke.id}, " +
            "Experiencia base: ${poke.base_experience}, " +
            "y estadistica total: ${poke.getTotalStat()}")
    }
    println("--------------------------------------------------------------------------")

    /**
     * Comparación por el criterio ingresado por el usuario
     */
    println("--------------------------------------------------------------------------")
    val criterio: (Pokemon) -> (Double) = CriterioBuilder.byUserInput(inputCriterioDelUsuario)
    val superPokeByCanon = PokemonComparator(pokemons).useCustomCanon(criterio)
    println("El poke vencedor es ${superPokeByCanon.name} con valor ${criterio(superPokeByCanon)}")
    println("--------------------------------------------------------------------------")

    /**
     * Comparación por experiencia base
     */
    val superPoke = PokemonComparator(pokemons).byBaseExperience()
    println("--------------------------------------------------------------------------")
    println("El ganador por base de experiencia es: ${superPoke.name} con ${superPoke.base_experience}")
    println("--------------------------------------------------------------------------")

    /**
     * Comparación por el valor total de las estadísticas del [pokemon]
     */
    val pokeCampeonByStat = PokemonComparator(pokemons).byTotalStat()
    println("--------------------------------------------------------------------------")
    println("El poke con mayor stat es: ${pokeCampeonByStat.name} con ${pokeCampeonByStat.getTotalStat()}")
    println("--------------------------------------------------------------------------")

    /**
     * Comparación por criterio (ID)
     */
    println("--------------------------------------------------------------------------")
    val superPokeByID = PokemonComparator(pokemons).useCustomCanon { poke -> poke.id.toDouble() }
    println("El poke con mayor ID es ${superPokeByID.name} con id  ${superPoke.id}")
    println("--------------------------------------------------------------------------")


}