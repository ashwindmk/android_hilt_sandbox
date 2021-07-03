package com.ashwin.android.hiltsandbox.data

import android.content.Context

/**
 * Activity scoped
 */
class PostRepository(private val context: Context) {
    private val posts = listOf<Post>(
        Post(1L, "user1", "Title One", "This is message one."),
        Post(2L, "user2", "Title Two", "This is message two."),
        Post(3L, "user1", "Title Three", "This is message three."),
        Post(4L, "user2", "Title Four", "This is message four."),
        Post(5L, "user3", "Title Five", "This is message five.")
    )

    fun getPosts(): List<Post> {
        val username = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
            .getString("username", null)

        return posts
            .filter { it.username != username }
    }
}
