import java.util.Scanner

/**
 * Permite la interacción usuario-programa por medio del ingreso de datos por consola.
 */
class CLI {

    /**
     * Registra el ingreso por teclado.
     */
    fun getConsoleEntry(): String {
        val userInput = Scanner(System.`in`)
        return userInput.nextLine()
    }

    /**
     * Devuelve un array de nombres de pokemon en base al ingreso del usuario.
     */
    fun getPokemonNames(): List<String> {
        return this.getConsoleEntry().split(" ")
     }

}

