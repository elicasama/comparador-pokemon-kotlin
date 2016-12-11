package domain

/**
 * Brinda información de los Pokemon de manera online
 */
class PokedexOnline : Pokedex {

    private val pokeApi = PokeApi.new()

    override fun getPokemonByName(name: String): Pokemon {
        return this.pokeApi.getPokemonByName(name).execute().body()
    }

}
