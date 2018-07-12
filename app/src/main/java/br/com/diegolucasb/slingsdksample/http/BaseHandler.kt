package br.com.diegolucasb.slingsdksample.http

import okhttp3.Headers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by isantana on 24-Jan-18.
 */
abstract class BaseHandler<T>: Callback<T> {

    protected abstract var success: ((T?) -> Unit)?
    protected abstract var error: ((errorData: Any?) -> Unit)?

    lateinit var responseHeader: Headers
        private set

    abstract fun list(parameters: Map<String, String> = mapOf(),
                      success: ((T?) -> Unit)? = null,
                      error: ((errorData: Any?) -> Unit)? = null)

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        error?.invoke(t)
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        response?.let {
            responseHeader = it.headers()
            if(it.isSuccessful) {
                success?.invoke(it.body())
            } else {
                error?.invoke(it)
            }
        }
    }

}

