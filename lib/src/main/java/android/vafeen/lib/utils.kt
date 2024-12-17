package android.vafeen.lib

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

fun <T : Any> MutableSynchronousFlow<T>.asSynchronousFlow(): SynchronousFlow<T> = this


@Composable
fun <T : Any> SynchronousFlow<T>.asState(): State<T> {
    // Remember the current state
    val state = remember { mutableStateOf(getValue()) }

    // Update the state whenever SynchronousFlow emits a new value
    DisposableEffect(this) {
        val listener: (T) -> Unit = { value -> state.value = value }
        collect(listener)

        onDispose {
            unCollect(listener)
        }
    }

    return state
}