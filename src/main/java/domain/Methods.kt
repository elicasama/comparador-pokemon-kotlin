package domain

/**
 * Permite manipular los métodos de una clase
 * ToDo: pasar el la clase a analizar por parametro
 */
class Methods() {
    val clasePokemonComparator = PokemonComparator::class.java

    fun getMethods() {
        val metodosPokemonComparator = clasePokemonComparator.getDeclaredMethods()

        for (metodo in metodosPokemonComparator)
        {
            System.out.println(metodo.getName())
        }
    }

}
