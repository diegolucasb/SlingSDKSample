package br.com.diegolucasb.slingsdksample.http.response

/**
 * Created by diegolucasb on 26/06/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
class BaseResponse<out T>(
        val data: T,
        val messages: List<String>,
        val page: Int = 0,
        val pageSize: Int = 0,
        val total: Int = 0)