package br.com.diegolucasb.slingsdksample.http

/**
 * Class to create a singleton with arguments
 * @param T type of the singleton class
 * @param A type of the argument to pass to the singleton
 * @param creator function to create the object
 */
abstract class MultitonHolder<out T, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile
    private var instance: MutableList<Pair<T, A>> = mutableListOf()

    /**
     * Creates the object instance
     * @param arg argument to pass to the singleton
     * @return singleton instance
     */
    fun getInstance(arg: A): T {
        // verifica se ja existe um objeto instanciado
        val originalInstance = instance
        if (originalInstance.isNotEmpty()) {
            originalInstance.forEach {
                if (it.second == arg) return it.first
            }
        }

        // cria uma nova instancia verificando se ela ja existe em outra thread
        return synchronized(this) {
            val multiThreadInstance = instance.find { it.second == arg }
            if (multiThreadInstance != null) {
                multiThreadInstance.first
            } else {
                val created = creator!!(arg)
                instance.add(Pair(created, arg))
                created
            }
        }
    }
}