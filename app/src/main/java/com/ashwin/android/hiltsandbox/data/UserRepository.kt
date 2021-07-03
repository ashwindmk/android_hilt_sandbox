package com.ashwin.android.hiltsandbox.data

import android.content.Context

/**
 * App scoped
 */
class UserRepository {
    private val users = listOf<User>(
        User(1L, "user1", "pass123", "Alice Williams"),
        User(2L, "user2", "pass123", "Bob Builder"),
        User(3L, "user3", "pass123", "Clara Samson")
    )

    fun getUser(username: String, password: String): User? {
        for (user in users) {
            if (user.username == username && user.password == password) {
                return user
            }
        }
        return null
    }
}
