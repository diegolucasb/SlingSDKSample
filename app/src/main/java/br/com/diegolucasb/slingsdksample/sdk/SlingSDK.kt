package br.com.diegolucasb.slingsdksample.sdk

import br.com.diegolucasb.slingsdksample.di.Injector
import br.com.diegolucasb.slingsdksample.http.ContactHandler
import br.com.diegolucasb.slingsdksample.http.request.MerchantsServices
import br.com.diegolucasb.slingsdksample.http.request.MerchantsServicesImpl
import br.com.diegolucasb.slingsdksample.http.response.BaseResponse
import org.kodein.di.generic.instance

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */

class SlingSDK(
        val url: String,
        val authenticationToken: String = "",
        val headers: Map<String, String>? = null,
        val listener: RequestListener? = null
        ) {

    private constructor(builder: Builder) : this(
            builder.url,
            builder.authenticationToken,
            builder.headers,
            builder.listener)

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    lateinit var merchant: MerchantsServices
        private set

    class Builder {
        var url: String = "" //BuildConfig.DEFAULT_URL
        var headers: Map<String, String>? = null
        var authenticationToken: String = ""
        var listener: RequestListener? = null

        fun build() = SlingSDK(this).apply {
            //injectors
            val instance by Injector.getContactServiceGraph(url, authenticationToken).baseKodein.instance<ContactHandler>()
            merchant = MerchantsServicesImpl(contact = instance)

        }
    }

    interface RequestListener {
        fun success(response: BaseResponse<*>)
        fun fail(e: Any?)
    }

}