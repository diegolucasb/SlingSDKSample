package stone.com.br.kotlinsdk.repository

import br.com.diegolucasb.slingsdksample.http.SlingHandler

/**
 * Created by renan.silva on 15/02/2018.
 */
interface RemoteDataSource<T> {

    fun getData(callback: SlingHandler.BaseListener<T>, args: Map<String, String> = emptyMap())
}