package domain

/**
 * Permite conocer las opciones de comparación
 */
class OptionsMenu(private val options: List<String>)  {

    /**
     * TODO: Escribir documentación
     */
    fun printOptions( ){
        val optionMapString = this.getMapOfOptions()
        optionMapString.forEach {
            println("La clave ${it.key}, el valor ${it.value})")
        }
    }

    private fun getMapOfOptions(): Map<String, String> {
        return this.options.associate({
            Pair(this.options.indexOf(it).toString(), it)
        })
    }

}