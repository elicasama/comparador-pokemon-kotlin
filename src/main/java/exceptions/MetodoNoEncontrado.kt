package exceptions

/**
 * Cuando se ingresa un método inválido
 */
class MetodoNoEncontrado (message: String?) : RuntimeException(message) {
}

