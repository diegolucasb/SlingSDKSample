package br.com.diegolucasb.slingsdksample.http

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by isantana on 24-Jan-18.
 */
abstract class BaseRestHandler<T> : BaseHandler<T>(), Callback<T> {

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        listener?.error(t)
    }

    override fun onResponse(call: Call<T>?, response: Response<T>?) {
        response?.let {
            listener?.responseHeader = it.headers()
            if (it.isSuccessful) {
                listener?.success(it)
            } else {
                listener?.error(it)
            }
        }
    }
}
