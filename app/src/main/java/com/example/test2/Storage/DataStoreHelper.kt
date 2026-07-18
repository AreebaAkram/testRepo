package com.example.test2.Storage

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

class DataStoreHelper(context : Context) {


    // Extension property -- every context object now has additional datastore property
    // by (property delegation) -- creates datastore only when needed

    private val Context.dataStore by preferencesDataStore(
        name = "user_preferences"
    )

}