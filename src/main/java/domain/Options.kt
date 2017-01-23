package domain


import java.util.*

/**
 * Permite conocer las opciones de comparación
 */
class Options(methods: List<String>)  {
    var index: String = ""
    var option: String = ""
    var mapOptions = HashMap<String,String>()
    val options: List<String> = methods

    fun getMapOfOptions( ): HashMap<String, String> {

        while (this.options.count() !== 0) {
            this.mapOptions.put(this.index, this.option)
            this.index + 1
        }
      return this.mapOptions

    }

    fun printMap( ){
        //val optionMapString = this.getMapOfOptions()
        //val it = optionMapString.iterator()
        var optionMapString = HashMap<String,String>()
        val it = optionMapString.iterator()
        println("--------------------------------------------------------------------------")
        println("la otra opción es")
        println("--------------------------------------------------------------------------")

        optionMapString.put("1","uno")
        optionMapString.put("2","dos")
        optionMapString.put("3","tres")

        while (it.hasNext()) {
            val key = it.next()
            println("Aloha!")
            println("Clave: " + key + " -> Valor: " + optionMapString.values)
        }
        return
    }

}