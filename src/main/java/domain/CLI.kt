import java.util.Scanner

/**
 * Permite la interacción usuario-programa por medio del ingreso de datos por consola.
 */
class CLI {

    /**
     * Registra el ingreso por teclado.
     */
    fun consoleEntry(): String {
        val userInput = Scanner(System.`in`)
        return userInput.nextLine()
    }

    /**
     * Devuelve un array de nombres de pokemon en base al ingreso del usuario.
     */
    fun getPokemonNames(): List<String> {
        println("Por favor introduzca los nombres de pokemon a comparar separados por espacios")
        println("Presione ENTER para terminar")
        return this.consoleEntry().split(" ")
     }
    /**
     * Devuelve el criterio ingresado por el usuario para su evaluación.
     */
    fun getCriterio(): String {
        println("Por favor introduzca el criterio de evaluación")
        println("Presione ENTER para terminar")
        return this.consoleEntry()
    }

}

