package com.bccxraion.consure.data.source.local.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey


object DataStoreUtil {
    const val DATA_STORE_NAME = "CONSURE_DATA_STORE"
    val TOKEN_PREF_KEY = stringPreferencesKey("TOKEN_PREF_KEY")
    val IS_REMEMBER_ME_PREF_KEY = booleanPreferencesKey("IS_REMEMBER_ME_PREF_KEY")
}