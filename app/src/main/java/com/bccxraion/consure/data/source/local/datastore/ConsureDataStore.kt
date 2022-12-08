package com.bccxraion.consure.data.source.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConsureDataStore(private val context: Context) {
    
    private val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore(
        name = DataStoreUtil.DATA_STORE_NAME
    )
    
    suspend fun saveToken(token: String) {
        context.userPreferenceDataStore.edit {
            it[DataStoreUtil.TOKEN_PREF_KEY] = token
        }
    }
    
    suspend fun saveIsRememberMe(isRememberMe: Boolean) {
        context.userPreferenceDataStore.edit {
            it[DataStoreUtil.IS_REMEMBER_ME_PREF_KEY] = isRememberMe
        }
    }
    
    suspend fun deleteToken() {
        context.userPreferenceDataStore.edit {
            it.remove(DataStoreUtil.TOKEN_PREF_KEY)
        }
    }
    
    fun readIsRememberMe() = context.userPreferenceDataStore.data
        .map {
            it[DataStoreUtil.IS_REMEMBER_ME_PREF_KEY] ?: false
        }
    
    fun readToken(): Flow<String?> = context.userPreferenceDataStore.data
        .map {
            it[DataStoreUtil.TOKEN_PREF_KEY]
        }
    
}