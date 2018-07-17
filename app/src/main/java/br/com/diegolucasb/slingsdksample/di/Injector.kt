package br.com.diegolucasb.slingsdksample.di

import br.com.diegolucasb.slingsdksample.http.AddressHandler
import br.com.diegolucasb.slingsdksample.http.ContactHandler
import br.com.diegolucasb.slingsdksample.http.PartnerHandler
import br.com.diegolucasb.slingsdksample.http.RetrofitHandler
import br.com.diegolucasb.slingsdksample.http.request.AddressService
import br.com.diegolucasb.slingsdksample.http.request.ContactService
import br.com.diegolucasb.slingsdksample.http.request.MerchantsServices
import br.com.diegolucasb.slingsdksample.http.request.MerchantsServicesImpl
import br.com.diegolucasb.slingsdksample.http.request.PartnerService
import org.kodein.di.Kodein
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.multiton
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
object Injector {

    fun retrofitModule(url: String, token: String) = Kodein.Module("retrofit") {
        bind<RetrofitHandler>() with singleton {
            val retrofit = RetrofitHandler.getInstance(url)
            retrofit.headers = listOf(
                    "Authorization" to "Bearer $token",
                    "stoneCode" to "")
            retrofit
        }

    }

    fun getContactServiceModule(url: String, token: String, affiliationCode: Long?) = Kodein.Module("contacts") {
        bind<ContactService>() with provider { instance<RetrofitHandler>().buildCall(ContactService::class) }
        bind<ContactHandler>() with provider { ContactHandler(affiliationCode, instance()) }
    }

    fun getAddressServiceModule(url: String, token: String, affiliationCode: Long?) = Kodein.Module("address") {
        bind<AddressService>() with provider { instance<RetrofitHandler>().buildCall(AddressService::class) }
        bind<AddressHandler>() with provider { AddressHandler(affiliationCode, instance()) }
    }

    fun getPartnerServiceModule(url: String, token: String) = Kodein.Module("partner") {
        bind<PartnerService>() with provider { instance<RetrofitHandler>().buildCall(PartnerService::class) }
        bind<PartnerHandler>() with provider { PartnerHandler(instance()) }
    }

    fun getMerchantsGraph(url: String, token: String, affiliationCode: Long?) = Kodein.lazy {
        import(retrofitModule(url, token))
        import(getContactServiceModule(url, token, affiliationCode))
        import(getAddressServiceModule(url, token, affiliationCode))
        import(getPartnerServiceModule(url, token))
        bind<MerchantsServices>() with provider { MerchantsServicesImpl(instance(), instance(), instance()) }
    }.direct
}