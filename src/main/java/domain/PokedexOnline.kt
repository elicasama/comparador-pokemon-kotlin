package domain

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL


class PokedexOnline {

}

object PruebaHTTP {
    @JvmStatic fun main(args: Array<String>) {
        val gson = Gson()
        try {
            // Se abre la conexión
            val url = URL("https://pokeapi.co/api/v2/pokemon/1/")
            val conexion = url.openConnection()
            conexion.connect()

            // Lectura
            val InputStream = conexion.getInputStream()
            val OutputStream = conexion.outputStream()

            val pokemonBuffer = BufferedReader(InputStreamReader(InputStream))
            val pokemonParseado = gson.fromJson(pokemonBuffer, Pokemon::class.java)

            println(pokemonParseado.name.toString())


        } catch (e: MalformedURLException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

    }
}


