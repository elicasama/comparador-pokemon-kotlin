package extensions

fun <T> List<T>.asIndexedMap(): Map<Int, T> {
    return this.associate({
        Pair(this.indexOf(it), it)
    })
}
