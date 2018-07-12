package br.com.diegolucasb.slingsdksample.di

import br.com.diegolucasb.slingsdksample.http.ContactHandler
import br.com.diegolucasb.slingsdksample.http.RetrofitHandler
import br.com.diegolucasb.slingsdksample.http.request.ContactService
import br.com.diegolucasb.slingsdksample.http.request.MerchantsServices
import br.com.diegolucasb.slingsdksample.http.request.MerchantsServicesImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
object Injector {

    private fun retrofitModule(url: String, token: String) = Kodein.Module("retrofit", false, "", {
        bind<RetrofitHandler>() with singleton {
            val retrofit = RetrofitHandler(url)
            retrofit.headers = listOf("Authorization" to "Bearer $token")
            retrofit
        }
    })

    fun getContactServiceGraph(url: String, token: String, affiliationCode: Long?) = Kodein.lazy {
        import(retrofitModule(url, token))
        bind<ContactService>() with provider { instance<RetrofitHandler>().buildCall(ContactService::class) }
        bind<ContactHandler>() with provider { ContactHandler(affiliationCode, instance()) }
    }

    fun getMerchantsGraph(url: String, token: String) = Kodein.lazy {
        import(retrofitModule(url, token))
        bind<MerchantsServices>() with provider { MerchantsServicesImpl(instance()) }
    }


}