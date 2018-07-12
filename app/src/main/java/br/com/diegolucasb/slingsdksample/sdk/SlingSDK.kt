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
        val affiliationCode: Long? = null,
        val headers: Map<String, String>? = null) {

    private constructor(builder: Builder) : this(
            builder.url,
            builder.authenticationToken,
            builder.affiliationCode,
            builder.headers)

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    lateinit var merchant: MerchantsServices
        private set

    class Builder {
        var url: String = "" //BuildConfig.DEFAULT_URL
        var headers: Map<String, String>? = null
        var affiliationCode: Long? = null
        var authenticationToken: String = ""

        fun build() = SlingSDK(this).apply {
            //injectors
            val instance by Injector.getContactServiceGraph(url, authenticationToken, affiliationCode).baseKodein.instance<ContactHandler>()
            merchant = MerchantsServicesImpl(contact = instance)

        }
    }

}