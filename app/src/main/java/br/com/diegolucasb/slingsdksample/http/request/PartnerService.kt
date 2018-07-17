package br.com.diegolucasb.slingsdksample.http.request

import br.com.diegolucasb.slingsdksample.model.Partner
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by renan.silva on 27/06/2018.
 * Copyright (c) Stone Co. All rights reserved.
 * renan.silva@stone.com.br
 */
interface PartnerService {

    @GET("v1/configurations/partners")
    fun list(): Call<List<Partner>>
}