package com.karthik.android.techtestkmp.android.data.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.karthik.android.techtestkmp.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.OkHttpClient
/**
 * POC of Kotlin Multiplatform (Android Module)
 *
 *  For android alone http client setup with
 *  chucker interceptor.
 *
 *  @param context: instance of [Context]
 */
class HttpClientProvider(val context: Context) {

    /**
     * Method to setup Httpclient.
     *
     *  @return http client with chucker interceptor.
     */
    fun getClient(): HttpClient {

        val okHttpClient = OkHttpClient.Builder().apply {
            if(BuildConfig.DEBUG){
                addInterceptor(ChuckerInterceptor(context))
            }
        }.build()

        return HttpClient(OkHttp){
            engine {
                preconfigured = okHttpClient
            }
        }

    }
}