package com.codeplace.jetpackdatastorepreferences.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.codeplace.jetpackdatastorepreferences.model.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataStoreRepository(context: Context) {

    val dataStore = context.dataStore

    private object PreferencesKey{
        val FIRST_ACCESS = booleanPreferencesKey(name = "FIRST_ACCESS")
    }

    suspend fun saveAppEntry(){
        dataStore.edit { settings ->
            settings[PreferencesKey.FIRST_ACCESS] = false
        }
    }

    suspend fun readAppEntry(): Flow<UserPreferences> {
        return dataStore.data.catch { exception ->
            if(exception is IOException){
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map {
                preferences ->
                val isFirstUserAccess = preferences[PreferencesKey.FIRST_ACCESS] ?: true
                UserPreferences(isFirstUserAccess)
            }
    }

}










