package br.com.diegolucasb.slingsdksample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.diegolucasb.slingsdksample.sdk.SlingSDK

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stoneCode = 0L
        val token = ""

        val sdk = SlingSDK.build {
            url = ""
            authenticationToken = token
            headers = mapOf()
        }
        val list = sdk.merchant.contact.list(stoneCode)
    }
}
