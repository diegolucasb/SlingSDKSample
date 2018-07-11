package br.com.diegolucasb.slingsdksample.adapter

/**
 * Created by renan.silva on 22/05/2018.
 * Copyright (c) Stone Co. All rights reserved.
 * renan.silva@stone.com.br
 */
data class Resource<out T>(val status: Status,
                           val data: T?,
                           val error: Any? = null) {

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        fun <T> error(error: Any?, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, error)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data)
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}