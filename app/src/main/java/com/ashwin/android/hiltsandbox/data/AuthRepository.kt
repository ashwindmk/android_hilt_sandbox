package com.ashwin.android.hiltsandbox.data

import android.content.Context

/**
 * App scoped
 */
class AuthRepository(private val context: Context) {
    fun isLoggedIn(): Boolean {
        context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE).apply {
            return !getString("username", null).isNullOrBlank()
        }
    }

    fun login(username: String) {
        context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE).apply {
            edit().putString("username", username).apply()
        }
    }

    fun logout() {
        context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE).apply {
            edit().remove("username").apply()
        }
    }
}
