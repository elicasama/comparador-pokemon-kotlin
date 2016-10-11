import domain.PokedexOffline
import domain.PokemonComparator

fun main(args: Array<String>) {

    val pokedex = PokedexOffline()
    val nombrePoke1 = "charmander"
    val nombrePoke2 = "pikachu"

    val poke1 = PokedexOffline().getPokemonByName(nombrePoke1)
    val poke2 = PokedexOffline().getPokemonByName(nombrePoke2)

    /**
     * Presentación de los competidores
     */
    println("El pokemon 1 es:  ${poke1.name} , con id ${poke1.id} y una experiencia de ${poke1.base_experience}")
    println("El pokemon 1 es:  ${poke2.name} , con id ${poke2.id} y una experiencia de ${poke2.base_experience}")
    println("--------------------------------------------------------------------------" )

    /**
     * Comparación por base de experiencia
     */
    val superPoke = PokemonComparator(nombrePoke1,nombrePoke2).byBaseExperience()
    println("El ganador por base de experiencia es: ${superPoke.name} con ${superPoke.base_experience}")
    println("--------------------------------------------------------------------------")


    val statPoke1 = pokedex.getTotalStat(poke1)
    val statPoke2 = pokedex.getTotalStat(poke2)

    println("El stat de ${poke1.name} es  ${statPoke1}")
    println("El stat de ${poke2.name} es  ${statPoke2}")

    /**
     * Comparación por el valor total de las estadísticas del [pokemon]
     */
    val pokeCampeonByStat = PokemonComparator(nombrePoke1,nombrePoke2).byTotalStat()
    println("--------------------------------------------------------------------------")
    println("El pokemon campeón, con mayor stat es: ${pokeCampeonByStat.name} con ${pokedex.getTotalStat(pokeCampeonByStat)}")
    println("--------------------------------------------------------------------------")
}