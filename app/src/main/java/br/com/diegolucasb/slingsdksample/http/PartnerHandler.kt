package br.com.diegolucasb.slingsdksample.http

import br.com.diegolucasb.slingsdksample.http.request.PartnerService
import br.com.diegolucasb.slingsdksample.model.Address
import br.com.diegolucasb.slingsdksample.model.Partner
import retrofit2.Callback

/**
 * Created by diegolucasb on 10/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
class PartnerHandler(
        private val service: PartnerService): BaseHandler<List<Address>>() {

    override var success: ((List<Address>?) -> Unit)? = null
    override var error: ((errorData: Any?) -> Unit)? = null

    override fun list(parameters: Map<String, String>,
                      success: ((List<Address>?) -> Unit)?,
                      error: ((errorData: Any?) -> Unit)?) {
        this.success = success
        this.error = error

        service.list().enqueue(this as Callback<List<Partner>>)

    }

}