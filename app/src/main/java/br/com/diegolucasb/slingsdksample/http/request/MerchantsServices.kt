package br.com.diegolucasb.slingsdksample.http.request

import br.com.diegolucasb.slingsdksample.http.AddressHandler
import br.com.diegolucasb.slingsdksample.http.ContactHandler
import br.com.diegolucasb.slingsdksample.http.PartnerHandler

/**
 * Created by diegolucasb on 09/07/18.
 * Copyright (c) Stone Co. All rights reserved.
 * lucas.amaral@stone.com.br
 */
abstract class MerchantsServices(
        val contact: ContactHandler,
        val address: AddressHandler,
        val partner: PartnerHandler)