package br.com.diegolucasb.slingsdksample.http.request

import br.com.diegolucasb.slingsdksample.model.Address
import br.com.diegolucasb.slingsdksample.http.response.BaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by renan.silva on 27/06/2018.
 * Copyright (c) Stone Co. All rights reserved.
 * renan.silva@stone.com.br
 */
interface AddressService {

    @GET("merchants/{affiliationCode}/addresses")
    fun listAll(@Path("affiliationCode") affiliationCode: Long?):
            Call<BaseResponse<List<Address>>>
}