package com.example.livescore

import android.content.Context
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import com.example.livescore.data.remote.api.LivescoreApi
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

class LivescoreApiTest {
    private var context: Context? = null
    private var mockWebServer = MockWebServer()
    private lateinit var livescoreApi: LivescoreApi

    @Before
    fun Setup() {
        mockWebServer.start()

        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        context = InstrumentationRegistry.getInstrumentation().targetContext

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        livescoreApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(LivescoreApi::class.java)

        val jsonStream: InputStream = context!!.resources.assets.open("livescore.json")
        val jsonBytes: ByteArray = jsonStream.readBytes()

        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(String(jsonBytes))
        mockWebServer.enqueue(response)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun test_response() = runBlocking {
        val data = livescoreApi.getMatchDetails("315814")
        ViewMatchers.assertThat(data.data.away_team.name, CoreMatchers.equalTo("Arsenal FC"))
    }
}
