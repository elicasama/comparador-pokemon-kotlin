package domain

import domain.cli.CriterioInfo
import extensions.asIndexedMap

/**
 * Permite conocer las opciones de comparación
 */
class CanonMenu(canons: List<String>) {
    private val canons = canons.asIndexedMap()

    /**
     * Le pregunta el criterio a usar
     */
    fun askCanon(): CriterioInfo {
        println("Ingrese el número de opción:")
        this.printCanons()

        val selectedOption = CLI.getConsoleEntry()
        try {
            return CriterioInfo(
                    this.canons[selectedOption.toInt()] ?: throw NumberFormatException()
                    , "known"
            )
        } catch(e: NumberFormatException) {
            return this.askJsFunction()
        }
    }

    private fun askJsFunction(): CriterioInfo {
        println("Por favor introduzca el criterio de evaluación")
        println("Presione ENTER para terminar")
        val jsFunction = CLI.getConsoleEntry()
        return CriterioInfo(jsFunction, "custom")
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