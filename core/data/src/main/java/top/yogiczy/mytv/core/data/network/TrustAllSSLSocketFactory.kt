package top.yogiczy.mytv.core.data.network

import android.annotation.SuppressLint
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

object TrustAllSSLSocketFactory {
    @SuppressLint("CustomX509TrustManager")
    val trustManager = object : X509TrustManager {
        @SuppressLint("TrustAllX509TrustManager")
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        @SuppressLint("TrustAllX509TrustManager")
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            return arrayOf()
        }
    }

    val sslSocketFactory by lazy {
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf(trustManager), null)
        sslContext.socketFactory!!
    }

    private fun init() {
        HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory)
        HttpsURLConnection.setDefaultHostnameVerifier { _, _ -> true }
    }

    init {
        init()
    }
}