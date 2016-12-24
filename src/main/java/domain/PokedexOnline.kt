package domain

import exceptions.PokemonNoEncontrado
import exceptions.TiempoExcedido

/**
 * Brinda información de los Pokemon de manera online.
 */
class PokedexOnline : Pokedex {

    private val pokeApi = PokeApi.new()

    /**
     * Retorna un [Pokemon] dado el [name].
     */
    override fun getPokemonByName(name: String): Pokemon {
        try {
            return this.pokeApi.getPokemonByName(name).execute().body()
        } catch (e: java.net.SocketTimeoutException) {
            throw TiempoExcedido()
        } catch (e: java.lang.IllegalStateException){
            throw PokemonNoEncontrado(e.message)
        }

    }
}