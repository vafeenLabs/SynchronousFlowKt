package android.vafeen.synchronousflow

import android.vafeen.lib.MutableSynchronousFlow
import android.vafeen.lib.asSynchronousFlow
import androidx.lifecycle.ViewModel

internal class MainActivityViewModel : ViewModel() {
    private var initialValue = 1
    private val _flow = MutableSynchronousFlow(initialValue)
    val flow = _flow.asSynchronousFlow()
    fun updateValue() {
        initialValue += 1
        _flow.emit(initialValue)
    }
}