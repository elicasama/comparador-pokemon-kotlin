package exceptions

/**
 * Cuando se ingresa un nombre inválido de pokemon.
 */
class PokemonNoEncontrado(message: String?) : RuntimeException(message)  {

}

