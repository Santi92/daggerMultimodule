package com.marcosholgado.core.resource


class CmkCoreSettings private constructor(
    private val salesChannel: String,
    private val optionalClientClass: String?,
    private val optionalClientId: String = "",
    private val connectApiToken: String,
    private val logActive: Boolean,
    private val localeCmk: LocaleCmk
) {

    fun getSalesChannel() = salesChannel

    fun getOptionalClientClass() = optionalClientClass

    fun getOptionalClientId() = optionalClientId

    fun getConnectApiToken() = connectApiToken

    fun getLogActive() = logActive

    fun getLocaleCmk() = localeCmk


    class Builder {

        private var salesChannel: String? = null
        private var optionalClientClass: String? = null
        private var optionalClientId: String? = null
        private var connectApiToken: String? = null
        private var logActive: Boolean = false
        private var localeCmk: LocaleCmk? = null

        fun addSalesChannel(salesChannel: String) =
            apply { this.salesChannel = salesChannel }

        fun optionalClientClass(optionalClientClass: String) =
            apply { this.optionalClientClass = optionalClientClass }

        fun addOptionalClientId(optionalClientId: String) =
            apply { this.optionalClientId = optionalClientId }

        fun connectApiToken(connectApiToken: String) =
            apply { this.connectApiToken = connectApiToken }


        fun logActive(logActive: Boolean) =
            apply { this.logActive = logActive }

        fun addLocaleCmk(localeCmkApp: LocaleCmk) =
            apply { this.localeCmk = localeCmkApp }



        fun build() = CmkCoreSettings(
            salesChannel ?: error("salesChannel is required"),
            optionalClientClass,
            optionalClientId ?: error("optionalClientId is required"),
            connectApiToken ?: error("connectApiToken is required"),
            logActive,
            localeCmk ?: error("locale is required")
        )
    }
}

data class LocaleCmk(val language:String, val country: String)
