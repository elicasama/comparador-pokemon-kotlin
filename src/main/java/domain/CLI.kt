import java.util.Scanner

/**
 * Permite la interacción usuario-programa por medio de ingreso de datos por consola
 */
class CLI {

    /**
     * Registra el ingreso por teclado
     */
    fun consoleEntry(): String {
        var consoleEntry = ""
        val userInput = Scanner(System.`in`)
        consoleEntry = userInput.nextLine()
        return consoleEntry
    }

    /**
     * Genera un array de nombres de pokemon en base al ingreso del usuario
     */
    fun getPokemonNames():  List<String> {
        println("Por favor introduzca los nombres de pokemon a comparar")
        println("Presione ENTER para terminar")
        val namesEntry = this.consoleEntry()

        println("Entrada recibida por teclado es: \"" + namesEntry + "\"")
        var pokemonsNames = namesEntry.split(" ")

        return pokemonsNames
    }
}




//val reg = Regex("(?<=[!?])|(?=[!?])")
