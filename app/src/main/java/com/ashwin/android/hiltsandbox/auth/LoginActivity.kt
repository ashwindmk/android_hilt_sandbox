package com.ashwin.android.hiltsandbox.auth

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ashwin.android.hiltsandbox.R
import com.ashwin.android.hiltsandbox.databinding.ActivityLoginBinding
import com.ashwin.android.hiltsandbox.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    companion object {
        fun launch(activity: Activity) {
            activity.startActivity(Intent(activity, LoginActivity::class.java))
        }
    }

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
            .also {
                loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
                it.viewModel = loginViewModel
                it.lifecycleOwner = this
            }

        loginViewModel.loginStatusLiveData.observe(this@LoginActivity, {
            if (it) {
                HomeActivity.launch(this@LoginActivity)
                finish()
            }
        })

        loginViewModel.isLoggedIn()
    }
}
