package br.com.diegolucasb.slingsdksample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.diegolucasb.slingsdksample.sdk.SlingSDK

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stoneCode = 192489630L
        val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJUb2tlbkNvZGUiOiI0RDQyN0EzQkZEQTFBMjhDOTEzNDQ4MDIwNkJGQjI2RUM3MkY4QzkwN0FENkJDNzNEQUM2NzNBNjE3OTJCRUUzNDE2MkM4RDAxQUM5NjE3RjEwQjk1NTcxNEI4RjJBNDc5NTI2NzhBMDI0OEYzQUUxNDZFNzYwMThFMkM4N0RBNjA2RjFBMzE2MDQ0RjQxRTE3QjQ4Q0Q3RTQ1QzcxOTRCNThCOEE1NzU4MDhCMEUyMyIsIlVzZXJJZCI6NDU0MDM5LCJDdXN0b21TdG9uZUNvZGUiOm51bGx9.BqZoMUAPWPLULBNCzUcUkYjjtPmsfD4lvXPtRa92GfQ"

        val sdk = SlingSDK.build {
            url = "https://customer-api.stone.com.br/v0/"
            authenticationToken = token
            affiliationCode = stoneCode
            headers = mapOf()
        }

//        sdk.merchant.apply { init() }
        sdk.merchant.contact.list(
                success = { Log.i("SDK", it?.data?.forEach { it.toString() }.toString())},
                error = { Log.e("SDK", it.toString()) }
        )

    }
}
