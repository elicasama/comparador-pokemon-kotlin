package domain


import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL



object PruebaHTTP {
    @JvmStatic fun main(args: Array<String>) {
        try {
            // Se abre la conexión
            val url = URL("http://www.chuidiang.com")
            //val url = URL("https://pokeapi.co/api/v2/pokemon/1/")
            val conexion = url.openConnection()
            conexion.connect()

            // Lectura
            val `is` = conexion.inputStream
            val br = BufferedReader(InputStreamReader(`is`))
            val buffer = CharArray(1000)
            var leido= br.read(buffer)
                println(String(buffer, 0, leido))
        } catch (e: MalformedURLException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

    }
}
