package com.ashwin.android.hiltsandbox.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashwin.android.hiltsandbox.data.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: AuthService) : ViewModel() {
    val usernameLiveData = MutableLiveData<String>("")
    val passwordLiveData = MutableLiveData<String>("")

    val loginStatusLiveData = MutableLiveData<Boolean>(false)

    init {
        Log.d("hilt-sandbox", "authService: $authService")
    }

    fun isLoggedIn() {
        if (authService.isLoggedIn()) {
            loginStatusLiveData.postValue(true)
        }
    }

    fun login() {
        val username = usernameLiveData.value
        val password = passwordLiveData.value
        if (!username.isNullOrBlank() && !password.isNullOrBlank()) {
            if (authService.login(username, password)) {
                loginStatusLiveData.postValue(true)
            }
        }
    }
}
