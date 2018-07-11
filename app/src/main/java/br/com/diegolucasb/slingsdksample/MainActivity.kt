package br.com.diegolucasb.slingsdksample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.diegolucasb.slingsdksample.http.response.BaseResponse
import br.com.diegolucasb.slingsdksample.sdk.SlingSDK

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stoneCode = 192489630L
        val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJUb2tlbkNvZGUiOiI0RDQyN0EzQkZEQTFBMjhDOTEzNDQ4MDIwNkJGQjI2RUM3MkY4QzkwN0FENkJDNzNEQUM2NzNBNjE3OTJCRUUzMUY1MTQwQzFDOTIxRTc5RUREQUU1NkZCRjgwRjE0NjY2RjkzQThBMTk2RkE1NzUzNDZFNzYwMThFMkM4N0RBNjA2RjFBMzE2MDQ0RjQxRTEwRjRDQkIyOTRERjIxMTE4MzFGMTYwQzZDMDBCRDdGRiIsIlVzZXJJZCI6NDU0MDM5LCJDdXN0b21TdG9uZUNvZGUiOm51bGx9.N1J7P5aVL9htgO3DuogJBqC6uAVfXOw1iDJ5EVY8rWM"

        val sdk = SlingSDK.build {
            url = "https://customer-api.stone.com.br/v0/"
            authenticationToken = token
            headers = mapOf()
            listener = object: SlingSDK.RequestListener{
                override fun fail(e: Any?) {
                }

                override fun success(response: BaseResponse<*>) {
                    1
                }

            }
        }

        sdk.merchant.contact.list(stoneCode)

    }
}
