package br.com.diegolucasb.slingsdksample.model

import java.io.Serializable

/**
 * Created by renan.silva on 27/03/2018.
 */
data class Address(
        var id: Long? = null,
        var affiliationCode: String? = null,
        var typeId: Long? = null,
        var typeName: String? = null,
        var cityId: Long? = null,
        var cityName: String? = null,
        var stateName: String? = null,
        var countryId: Long? = null,
        var countryName: String? = null,
        var complement: String? = null,
        var locatedInShopping: Boolean? = null,
        var neighborhood: String? = null,
        var postalCode: String? = null,
        var reference: String? = null,
        var streetName: String? = null,
        var streetNumber: String? = null,
        var streetTypeId: Long? = null) : Serializable
