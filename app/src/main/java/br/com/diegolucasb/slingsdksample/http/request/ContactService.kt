package br.com.diegolucasb.slingsdksample.http.request

import br.com.diegolucasb.slingsdksample.http.response.BaseResponse
import br.com.diegolucasb.slingsdksample.model.Contact
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
interface ContactService {

    @GET("merchants/{affiliationCode}/contacts")
    fun list(@Path("affiliationCode") affiliationCode: Long?): Call<BaseResponse<List<Contact>>>

}