package ke.don.birdie.feedback.config

import kotlin.concurrent.Volatile

object BirdieSdk {
    @Volatile
    private var instance: Birdie? = null

    fun init(config: BirdieConfig) {
        check(instance == null) { "BirdieSdk is already initialized" }
        instance = BirdieFactory.create(config)
    }

    fun get(): Birdie =
        instance ?: error("BirdieSdk not initialized. Call BirdieSdk.init(config) first.")
}
