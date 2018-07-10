package br.com.diegolucasb.slingsdksample.sdk

import br.com.diegolucasb.slingsdksample.http.request.MerchantsServices

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */

class SlingSDK(
        url: String,
        headers: Map<String, String>? = null,
        authenticationToken: String? = null) {

    private constructor(builder: Builder) : this(builder.url, builder.headers, builder.authenticationToken)

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    lateinit var merchant: MerchantsServices
        private set

    class Builder {
        var url: String = "" //BuildConfig.DEFAULT_URL
        var headers: Map<String, String>? = null
        var authenticationToken: String? = null

        fun build() = SlingSDK(this).apply {
            //injectors
//            val instance by Injector.getMerchantsGraph("").baseKodein.instance<MerchantsServicesImpl>()
//            merchant = instance
        }
    }
}