import domain.*

fun main(args: Array<String>) {

    /**
     * Selección de Pokedex
     */
    val pokedex = PokedexOffline("./src/main/java/JSON")
//    val pokedex = PokedexOnline()

    /**
     * Selección de grupo de pokemons a comparar
     * TODO: generar un CLI para el ingreso de los pokemonName por parte del usuario
     */

//    val pokemons = pokedex.getPokemonsByNames(listOf("kakuna","charmander","bulbasaur", "pikachu"))
    val pokemons = pokedex.getPokemonsByNames(listOf("kakun","charmander"))

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
    val superPokeByID = PokemonComparator(pokemons).byCanon { poke -> poke.id.toDouble() }
    println("El poke con mayor ID es ${superPokeByID.name} con id  ${superPoke.id}")
    println("--------------------------------------------------------------------------")

}