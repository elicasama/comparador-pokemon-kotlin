package extensions

import javax.script.ScriptEngineManager

fun String.evalAsJs(): Any {
    val manager = ScriptEngineManager()
    val engine = manager.getEngineByName("js")
    return engine.eval(this)
}