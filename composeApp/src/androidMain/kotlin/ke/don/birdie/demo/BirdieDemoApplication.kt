package ke.don.birdie.demo

import android.app.Application
import ke.don.birdie.feedback.config.BirdieConfig
import ke.don.birdie.feedback.config.BirdieSdk

class BirdieDemoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val config = BirdieConfig(
            projectId = "df35f8db-bbe6-40f1-993f-8335e2a22eda",
            apiKey = "VCNU4Ul5TTgt2fbtAJVDiA==",
        )

        BirdieSdk.init(config)
    }
}