package ke.don.birdie_lib.network.api

import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ke.don.birdie_lib.model.BirdieResult
import ke.don.birdie_lib.model.NetworkError
import ke.don.birdie_lib.model.TestData
import ke.don.birdie_lib.network.KtorClientProvider.client
import ke.don.birdie_lib.network.klient

object BirdieApi {
    //TODO (make this internal after building sdk object)
    suspend fun fetchTestData(): BirdieResult<TestData, NetworkError> = klient {
        client.get(SupabaseEndpoint.TestTable.url) {
            contentType(ContentType.Application.Json)
            parameter("select", "*")
        }
    }
}