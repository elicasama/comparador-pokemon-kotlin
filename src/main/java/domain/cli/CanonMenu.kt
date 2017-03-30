package domain

import domain.cli.Canon
import domain.cli.KnownCanon
import domain.cli.CustomCanon
import extensions.asIndexedMap

/**
 * Permite conocer las opciones de comparación
 */
class CanonMenu(canons: List<String>) {
    private val canons = canons.asIndexedMap()

    /**
     * Le pregunta el criterio a usar
     */
    fun askCanon(): Canon {
        println("Ingrese el número de opción:")
        this.printCanons()

        val selectedOption = CLI.getConsoleEntry()
        try {
            return KnownCanon(
                    this.canons[selectedOption.toInt()] ?: throw NumberFormatException()
            )
        } catch(e: NumberFormatException) {
            return this.askJsFunction()
        }
    }

    private fun askJsFunction(): Canon {
        println("Por favor introduzca el criterio de evaluación")
        println("Presione ENTER para terminar")
        val jsFunction = CLI.getConsoleEntry()
        return CustomCanon(jsFunction)
    }

    /**
     * Imprime los criterios
     */
    private fun printCanons() {
        println("--------------------------------------------------------------------------")
        print("Los criterios para compararlos son: \n")
        println("--------------------------------------------------------------------------")
        this.canons.forEach { println("${it.key}: ${it.value}") }
        println("otro - usar función de javascript")
    }

}