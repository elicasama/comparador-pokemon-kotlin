import domain.CanonMenu
import domain.CriterioBuilder
import domain.PokemonComparator
import java.util.Scanner

/**
 * Permite la interacción usuario-programa por medio del ingreso de datos por consola.
 */
class CLI {

    companion object {
        /**
         * Registra el ingreso por teclado.
         */
        fun getConsoleEntry(): String {
            val userInput = Scanner(System.`in`)
            return userInput.nextLine()
        }
    }

    /**
     * Devuelve un array de nombres de pokemon en base al ingreso del usuario.
     */
    fun getPokemonNames(): List<String> {
        return CLI.getConsoleEntry().split(" ")
     }

    /**
     * Le pregunta al usuario el criterio y lo usa.
     */
    fun startComparition(comparator: PokemonComparator) {
        val criterioInfo = CanonMenu(comparator.availableCanons()).askCanon()

        val pokeGanador =
                if (criterioInfo.type == "known") {
                    comparator.useKnownCanon(criterioInfo.data)
                } else {
                    comparator.useCustomCanon(CriterioBuilder.byUserInput(criterioInfo.data))
                }

        println("El ganador es: \n ---> ${pokeGanador.name}")
        println("--------------------------------------------------------------------------")
    }

}

