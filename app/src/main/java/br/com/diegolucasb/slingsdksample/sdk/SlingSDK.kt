package br.com.diegolucasb.slingsdksample.sdk

import br.com.diegolucasb.slingsdksample.di.Injector
import br.com.diegolucasb.slingsdksample.http.request.MerchantsServices
import org.kodein.di.generic.instance

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 *
 * We decided to use Builder pattern in kotlin to keep it compatible with java clients.
 * We also cannot use DSL, cause it doesn't work with java clients
 */

class SlingSDK private constructor(
        var url: String,
        val authenticationToken: String,
        val affiliationCode: Long?,
        val headers: Map<String, String>?) {

    val merchant: MerchantsServices
        get() = Injector.getMerchantsGraph(url, authenticationToken, affiliationCode).instance()

    class Builder {
        private var url: String = "" //BuildConfig.DEFAULT_URL
        private var token: String = ""
        private var affiliationCode: Long? = null
        private var headers: Map<String, String>? = mapOf()

        fun withUrl(url: String) = apply { this.url = url }
        fun withHeaders(headers: Map<String, String>?) = apply { this.headers = headers }
        fun withAffiliationCode(affiliationCode: Long?) = apply { this.affiliationCode = affiliationCode }
        fun withToken(token: String) = apply { this.token = token }

        fun build() = SlingSDK(
                url,
                token,
                affiliationCode,
                headers)
    }

}