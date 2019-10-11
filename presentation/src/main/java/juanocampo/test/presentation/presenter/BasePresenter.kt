package juanocampo.test.presentation.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

open class BasePresenter<T>: CoroutineScope {

    protected var view: T? = null

    private val presenterJob: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = presenterJob + Dispatchers.IO

    fun bind(view: T) {
        this.view = view
    }

    fun unBind() {
        presenterJob.cancel()
    }

    protected suspend fun publishResults(function: () -> Unit) {
        withContext(Dispatchers.Main) {
            function.invoke()
        }
    }

}