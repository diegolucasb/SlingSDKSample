package br.com.diegolucasb.slingsdksample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.diegolucasb.slingsdksample.sdk.SlingSDK

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stoneCode = 192489630L
        val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJUb2tlbkNvZGUiOiI0RDQyN0EzQkZEQTFBMjhDOTEzNDQ4MDIwNkJGQjI2RUM3MkY4QzkwN0FENkJDNzNEQUM2NzNBNjE3OTJCRUUzNDE2MkM4RDAxQUM5NjE3RjEwQjk1NTcxNEI4RjJBNDc5NTI2NzhBMDI0OEYzQUUxNDZFNzYwMThFMkM4N0RBNjA2RjFBMzE2MDQ0RjQxRTE0RTY1Q0U4MTU0RTdBQjBBNjUzOEJBMEVEMUNGOTA5RSIsIlVzZXJJZCI6NDU0MDM5LCJDdXN0b21TdG9uZUNvZGUiOm51bGx9.z583kRaAiGziA30PuFXTfmGNvq2wuEbtKnNq9qoMTpU"

        val sdk = SlingSDK.build {
            url = "https://customer-api.stone.com.br"
            authenticationToken = token
            headers = mapOf()
        }

//        val list = sdk.merchant.address.list()

//        val contactService by Injector.getContactServiceGraph(
//                "https://customer-api.stone.com.br/v0/",
//                token).instance<RemoteDataSourceImpl<BaseRestHandler<BaseResponse<List<Contact>>>>>()
//        contactService.getData(object : SlingHandler<BaseResponse<List<Contact>>>{
//
//        }, mapOf())


    }
}
