package br.com.diegolucasb.slingsdksample.http

import br.com.diegolucasb.slingsdksample.http.request.ContactService
import br.com.diegolucasb.slingsdksample.http.response.BaseResponse
import br.com.diegolucasb.slingsdksample.http.response.Contact
import br.com.diegolucasb.slingsdksample.sdk.SlingSDK
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by diegolucasb on 10/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
class ContactHandler(private val service: ContactService) {

    var listener: SlingSDK.RequestListener? = null

    fun list(affiliationCode: Long) {
        service.list(affiliationCode).enqueue(object : Callback<BaseResponse<List<Contact>>>{
            override fun onFailure(call: Call<BaseResponse<List<Contact>>>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<BaseResponse<List<Contact>>>?, response: Response<BaseResponse<List<Contact>>>?) {
                response?.let {
                    if(it.isSuccessful()) {
                        listener?.success(it.body() as BaseResponse<*>)
                    } else {
                        listener?.fail(it)
                    }
                }
            }

        })

    }

}