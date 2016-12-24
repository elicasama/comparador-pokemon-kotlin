package domain

import com.google.gson.Gson
import extensions.evalAsJs

object CriterioBuilder {

    fun byUserInput(criterioIngresado: String): (Pokemon) -> (Double) {
        return { poke ->
            ("($criterioIngresado)(${Gson().toJson(poke)})".evalAsJs() as Number).toDouble()
        }
    }

}