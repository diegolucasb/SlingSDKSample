package br.com.diegolucasb.slingsdksample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import br.com.diegolucasb.slingsdksample.http.RetrofitHandler
import br.com.diegolucasb.slingsdksample.sdk.SlingSDK
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.multiton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stoneCode = 192489630L
        val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJUb2tlbkNvZGUiOiI0RDQyN0EzQkZEQTFBMjhDOTEzNDQ4MDIwNkJGQjI2RUM3MkY4QzkwN0FENkJDNzNEQUM2NzNBNjE3OTJCRUUzNDE2MkM4RDAxQUM5NjE3RjEwQjk1NTcxNEI4RjJBNDc5NTI2NzhBMDI0OEYzQUUxNDZFNzYwMThFMkM4N0RBNjA2RjFBMzE2MDQ0RjQxRTFGQkNGNzkyMDdCQzVFNzExODYxNERBRUI1NDdBNzQ2RSIsIlVzZXJJZCI6NDU0MDM5LCJDdXN0b21TdG9uZUNvZGUiOm51bGx9.6p2wkahXd2cG_Oq98qtPjpGC3I9Y6dkuXVDuLcaMY4g"
        val url = "https://customer-api.stone.com.br/v0/"

        val kodein = Kodein {
            bind<RetrofitHandler>() with multiton{ tag: String ->
                RetrofitHandler.getInstance(url)
            }
        }

        val val1 by kodein.instance<RetrofitHandler>()
        Log.i("kodein", val1.toString())

        val sdk = SlingSDK.Builder()
                .withUrl(url)
                .withToken(token)
                .withAffiliationCode(stoneCode)
                .withHeaders(mapOf("stoneCode" to "$stoneCode"))
                .build()

        sdk.merchant.contact.list(
                success = { Log.i("SDK-Contact", it?.data?.forEach { it.toString() }.toString())},
                error = { Log.e("SDK-Contact", it.toString()) }
        )

        sdk.also { it.url = "https://customer-api.stone.com.br/v1/" }.merchant.partner.list(
            success = { Log.i("SDK-Partner", it?.forEach { it.toString() }.toString())},
            error = { Log.e("SDK-Partner", it.toString()) }
        )

        sdk.merchant.address.list(
            success = { Log.i("SDK-Address", it?.data?.forEach { it.toString() }.toString())},
            error = { Log.e("SDK-Address", it.toString()) }
        )

    }
}
