import domain.PokedexOffline
import domain.PokemonComparator

fun main(args: Array<String>) {
    val pokedex = PokedexOffline()
    val pokemons = pokedex.getPokemonByNames(listOf("kakuna","charmander","bulbasaur", "pikachu"))

    /**
     * Comparación por base de experiencia
     */
    println("-------------------------")
    val poke = pokemons.iterator()
    println("Los participantes son:")
    println("-------------------------")
    while (poke.hasNext())
        System.out.println(poke.next().name)
    println("--------------------------------------------------------------------------")

    /**
     * Comparación por base de experiencia
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