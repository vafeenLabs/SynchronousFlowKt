package android.vafeen.lib

class MutableSynchronousFlow<T : Any>(initialValue: T) : SynchronousFlow<T>(initialValue) {

    fun emit(newValue: T) {
        tValue = newValue
    }
}




