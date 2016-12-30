package extensions

fun <T : Any> Class<T>.getMethodNames() : List<String> {
    return this.getDeclaredMethods().toList().map { method -> method.name }
}

fun <T> Any.invokeMethod(name: String, vararg args: Any): T {
    @Suppress("UNCHECKED_CAST")
    return this.javaClass.getMethod(name).invoke(this, *args) as T
}

/*
val dos = (3).minus(1)
val otroDos = (3).invokeMethod<Int>("minus", 1)
*/