package org.config

class Constants{
    companion object {
        @JvmField val ACCESS_TOKEN_VALIDITY_SECONDS: Long = 5*60*60;
        @JvmField val SINGING_KEY: String = "devglan123r";
        @JvmField val TOKEN_PREFIX: String = "Bearer";
        @JvmField val HEARER_STRING: String = "Authorization"

    }
}