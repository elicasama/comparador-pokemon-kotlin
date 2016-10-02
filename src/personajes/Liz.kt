package personajes

class Liz(private val poder: Float, private val edad: Int) {
    val edadMas100: Int get() = this.edad + 100
    var allByDefault: Int? = 8

    fun saludar() {
        println("Hola soy personajes.Liz y tengo $poder de poder y $edad de edad")

        this.edadMas100
    }
}