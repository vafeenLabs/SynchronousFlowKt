package android.vafeen.lib

open class SynchronousFlow<T : Any> internal constructor(initialValue: T) {
    private val collectors = mutableListOf<(T) -> Unit>()
    internal var tValue = initialValue
        set(value) = synchronized(tValue) {
            field = value
            notifyCollectors()
        }

    private fun notifyCollectors() {
        collectors.forEach {
            it(tValue)
        }
    }

    fun collect(collecting: (T) -> Unit) {
        collectors.add(collecting)
        collecting(tValue)
    }

    fun unCollect(collecting: (T) -> Unit) {
        collectors.remove(collecting)
    }

    fun getValue(): T = tValue
}