package br.com.diegolucasb.slingsdksample.http

/**
 * Created by isantana on 24-Jan-18.
 */
abstract class BaseHandler<T> : SlingHandler<T> {

    override var listener: SlingHandler.BaseListener<T>? = null
}