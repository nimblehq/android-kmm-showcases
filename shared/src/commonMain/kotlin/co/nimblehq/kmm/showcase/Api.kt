package co.nimblehq.kmm.showcase

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient

expect fun initLogger()

@Serializable
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)

class Api {
    private val httpClient = HttpClient(CIO) {
        install(Logging) {
            level = LogLevel.BODY
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HTTP Client", message = message)
                }
            }
        }
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }.also { initLogger() }

    @Throws(Throwable::class)
    suspend fun todoTask(): String {
        val todo = getTodo()
        return "User ID: ${todo.userId} \n" +
                "ID: ${todo.id} \n" +
                "Title: ${todo.title} \n" +
                "Completed: ${todo.completed}"
    }

    private suspend fun getTodo(): Todo {
        // TODO Update API Endpoint
        return httpClient.get("https://jsonplaceholder.typicode.com/todos/1")
    }
}