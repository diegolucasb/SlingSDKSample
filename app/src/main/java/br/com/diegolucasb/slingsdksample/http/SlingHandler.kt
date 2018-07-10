package br.com.diegolucasb.slingsdksample.http

import okhttp3.Headers
import retrofit2.Response

/**
 * Created by isantana on 24-Jan-18.
 */
interface SlingHandler<T> {

    var listener: BaseListener<T>?

    //TODO achar uma forma de nao passar um map para pegar os parametros
    fun execute(args: Map<String, String>)

    fun listener(listener: KBaseListener<T>.() -> Unit) {
        this.listener = KBaseListener<T>().apply(listener)
    }

    interface BaseListener<T> {
        fun success(successData: Response<T>)
        fun error(errorData: Any?)

        var responseHeader: Headers?
    }

    class KBaseListener<T> : BaseListener<T> {
        private var success: ((successData: Response<T>) -> Unit)? = null
        private var error: ((errorData: Any?) -> Unit)? = null

        override var responseHeader: Headers? = null

        override fun success(successData: Response<T>) {
            success?.invoke(successData)
        }

        override fun error(errorData: Any?) {
            error?.invoke(errorData)
        }

        fun onSuccess(success: (successData: Response<T>) -> Unit) {
            this.success = success
        }

        fun onError(error: (error: Any?) -> Unit) {
            this.error = error
        }
    }
}