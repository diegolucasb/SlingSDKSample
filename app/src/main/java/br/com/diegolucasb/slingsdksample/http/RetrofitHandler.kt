package br.com.diegolucasb.slingsdksample.http

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
class RetrofitHandler(private val baseUrl: String = "") {

    private val retrofit: Retrofit by lazy { buildRetrofit(baseUrl) }

    var headers = listOf<Pair<String, String>>()

    private fun buildRetrofit(baseUrl: String): Retrofit {
        val builder = OkHttpClient().newBuilder()
        builder.readTimeout(60, TimeUnit.SECONDS)
        builder.connectTimeout(60, TimeUnit.SECONDS)
        builder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
            for ((name, value) in headers) {
                request.addHeader(name, value)
            }
            chain.proceed(request.build())
        }

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(loggingInterceptor)

        val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create()

        return Retrofit.Builder().run {
            baseUrl(baseUrl)
            client(builder.build())
            addConverterFactory(GsonConverterFactory.create(gson))
            build()
        }
    }

    fun <T : Any> buildCall(kClass: KClass<T>): T = retrofit.create(kClass.java)


}