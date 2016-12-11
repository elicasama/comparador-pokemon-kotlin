package domain

import exceptions.TiempoExcedido

/**
 * Brinda información de los Pokemon de manera online
 */
class PokedexOnline : Pokedex {

    private val pokeApi = PokeApi.new()

    override fun getPokemonByName(name: String): Pokemon {
        try {
            return this.pokeApi.getPokemonByName(name).execute().body()
        } catch (e: java.net.SocketTimeoutException) {
          throw TiempoExcedido()
        }
    }
}