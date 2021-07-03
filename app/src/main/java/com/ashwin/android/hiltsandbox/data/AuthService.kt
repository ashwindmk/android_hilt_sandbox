package com.ashwin.android.hiltsandbox.data

class AuthService(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    fun isLoggedIn() = authRepository.isLoggedIn()

    fun login(username: String, password: String): Boolean {
        val user = userRepository.getUser(username, password)
        if (user != null) {
            authRepository.login(username)
            return true
        }
        return false
    }

    fun logout() = authRepository.logout()
}
