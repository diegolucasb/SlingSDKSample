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
class ContactHandler(
        private val affiliationCode: Long?,
        private val service: ContactService): BaseHandler<BaseResponse<List<Contact>>>() {

    override var success: ((BaseResponse<List<Contact>>?) -> Unit)? = null
    override var error: ((errorData: Any?) -> Unit)? = null

    override fun list(parameters: Map<String, String>,
                      success: ((BaseResponse<List<Contact>>?) -> Unit)?,
                      error: ((errorData: Any?) -> Unit)?) {
        this.success = success
        this.error = error

        service.list(affiliationCode).enqueue(this as Callback<BaseResponse<List<Contact>>>)

    }

}