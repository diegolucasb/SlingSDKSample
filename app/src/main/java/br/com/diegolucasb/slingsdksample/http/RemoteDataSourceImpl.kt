package stone.com.br.kotlinsdk.repository

import br.com.diegolucasb.slingsdksample.http.BaseRestHandler
import br.com.diegolucasb.slingsdksample.http.SlingHandler

/**
 * Created by isantana on 29-Jan-18.
 */
class RemoteDataSourceImpl<T>(private val restHandler: BaseRestHandler<T>) : RemoteDataSource<T> {

    override fun getData(callback: SlingHandler.BaseListener<T>, args: Map<String, String>) {
        restHandler.apply {
            execute(args)
            listener = callback
        }
    }
}