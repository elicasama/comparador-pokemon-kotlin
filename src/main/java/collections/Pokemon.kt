package collections

import java.util.*

/**
 * Clase Pokemon, se va a instanciar con un JSON
 */
class Pokemon () {
    var id = 0
    lateinit var name: String
    var base_experience = 0
    lateinit var stats: ArrayList<Stat>
}