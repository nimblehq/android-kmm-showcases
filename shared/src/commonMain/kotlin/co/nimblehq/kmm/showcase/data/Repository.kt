package co.nimblehq.kmm.showcase.data

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

private const val API_HOST = "https://e582a6ab-90d0-4766-96f2-95efcb61de18.mock.pstmn.io"
private const val API_ENDPOINT = "/api/v1/jobs/a46978ca-a359-11ec-ae63-02ceb8cb4b90"

interface Repository {
    suspend fun getJobDetails(): JobDetails
}

class RepositoryImpl() : Repository {

    private val api = Api()

    override suspend fun getJobDetails(): JobDetails {
        // Workaround to resolve parsing exception: https://stackoverflow.com/a/65105432
        return try {
            api.httpClient.get<Data>(API_HOST + API_ENDPOINT).data
        } catch (e: NoTransformationFoundException) {
            val jsonString: String = api.httpClient.get(API_HOST + API_ENDPOINT)
            val json = Json { ignoreUnknownKeys = true }
            json.decodeFromString<Data>(jsonString).data
        }
    }
}
