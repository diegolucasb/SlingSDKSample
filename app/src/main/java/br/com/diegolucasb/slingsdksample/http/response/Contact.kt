package br.com.diegolucasb.slingsdksample.http.response

import java.io.Serializable

data class Contact(
        val name: String,
        val typeId: Long,
        val typeName: String,
        val email: String,
        val phone: String,
        val mobilePhone: String,
        val id: Long? = null) : Serializable