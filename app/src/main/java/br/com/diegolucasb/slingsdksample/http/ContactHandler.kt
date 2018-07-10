package br.com.diegolucasb.slingsdksample.http

import br.com.diegolucasb.slingsdksample.http.request.ContactService
import br.com.diegolucasb.slingsdksample.http.response.BaseResponse
import br.com.diegolucasb.slingsdksample.http.response.Contact
import retrofit2.Callback

/**
 * Created by diegolucasb on 10/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
class ContactHandler(private val service: ContactService)
    : BaseRestHandler<BaseResponse<List<Contact>>>() {

    override fun execute(args: Map<String, String>) {
        val par = args["affiliationCode"] ?: "0"
        service.list(par.toLong()).enqueue(this as Callback<BaseResponse<List<Contact>>>)
    }

}