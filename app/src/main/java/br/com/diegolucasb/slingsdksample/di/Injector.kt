package br.com.diegolucasb.slingsdksample.di

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
object Injector {

//    fun retrofitModule(url: String) = Kodein.Module("retrofit", false, "", {
//        bind<RetrofitHandler>() with singleton {
//            val retrofit = RetrofitHandler(url)
//            retrofit
//        }
//    })
//
//    fun getMerchantsGraph(url: String) = Kodein.lazy {
//        import(retrofitModule(url))
//        bind<ContactService>() with provider { instance<RetrofitHandler>().buildCall(ContactService::class) }
//        bind<MerchantsServices>() with provider { MerchantsServicesImpl(instance()) }
//    }


}