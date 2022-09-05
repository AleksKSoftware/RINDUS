@file:Suppress("FunctionName")

package no.rindus.android.rindus.data.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import no.rindus.android.rindus.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

inline fun <reified T> api(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}

fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


fun retrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(okHttpClient)

    .build()

private const val TIMEOUT = 30L

fun httpClient(loggingInterceptor: LoggingInterceptor): OkHttpClient = clientBuilder()
    .addInterceptor(loggingInterceptor)
    .build()

fun clientBuilder() = OkHttpClient.Builder()
    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
    .readTimeout(TIMEOUT, TimeUnit.SECONDS)
    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
