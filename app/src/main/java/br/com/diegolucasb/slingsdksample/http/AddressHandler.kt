package br.com.diegolucasb.slingsdksample.http

import br.com.diegolucasb.slingsdksample.http.request.AddressService
import br.com.diegolucasb.slingsdksample.model.Address
import br.com.diegolucasb.slingsdksample.http.response.BaseResponse
import retrofit2.Callback

/**
 * Created by diegolucasb on 10/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
class AddressHandler(
        private val affiliationCode: Long?,
        private val service: AddressService): BaseHandler<BaseResponse<List<Address>>>() {

    override var success: ((BaseResponse<List<Address>>?) -> Unit)? = null
    override var error: ((errorData: Any?) -> Unit)? = null

    override fun list(parameters: Map<String, String>,
                      success: ((BaseResponse<List<Address>>?) -> Unit)?,
                      error: ((errorData: Any?) -> Unit)?) {
        this.success = success
        this.error = error

        service.listAll(affiliationCode).enqueue(this as Callback<BaseResponse<List<Address>>>)

    }

}