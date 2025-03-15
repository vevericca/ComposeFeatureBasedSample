package com.vevericca.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import com.vevericca.network.BuildConfig
import com.vevericca.network.api.StoreApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object {
        const val TIMEOUT = 30000L
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logs = HttpLoggingInterceptor()
        logs.level = HttpLoggingInterceptor.Level.BODY
        return logs

    }

    @Provides
    fun provideNewsApiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request =
                chain.request().newBuilder()
                    .url(
                        chain.request().url.newBuilder()
                            .addQueryParameter("apiKey", "key")
                            .build()
                    )
                    .build()
            chain.proceed(request)
        }
    }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, keyInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(loggingInterceptor)
            .addInterceptor(keyInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): StoreApi {
        val jsonConverterFactory = Json.asConverterFactory("application/json".toMediaType())

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient)
            .addConverterFactory(jsonConverterFactory)
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .build()
        return retrofit.create(StoreApi::class.java)
    }
}