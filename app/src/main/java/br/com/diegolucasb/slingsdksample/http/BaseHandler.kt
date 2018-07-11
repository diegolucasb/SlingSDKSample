package br.com.diegolucasb.slingsdksample.http

import br.com.diegolucasb.slingsdksample.sdk.SlingSDK

/**
 * Created by isantana on 24-Jan-18.
 */
abstract class BaseHandler<T> {

    var listener: SlingSDK.RequestListener? = null
}