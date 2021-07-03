package com.ashwin.android.hiltsandbox.home

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.ashwin.android.hiltsandbox.R
import com.ashwin.android.hiltsandbox.auth.LoginActivity
import com.ashwin.android.hiltsandbox.data.PostRepository
import com.ashwin.android.hiltsandbox.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    companion object {
        fun launch(activity: Activity) {
            activity.startActivity(Intent(activity, HomeActivity::class.java))
        }
    }

    private val homeViewModel: HomeViewModel by viewModels()

    @Inject lateinit var postRepository: PostRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
            .also {
                it.viewModel = homeViewModel
            }
            .apply {
                reopenButton.setOnClickListener {
                    HomeActivity.launch(this@HomeActivity)
                    finish()
                }
            }

        homeViewModel.logInstances()
        Log.d("hilt-sandbox", "Activity postRepository: $postRepository")

        homeViewModel.loginStatusLiveData.observe(this@HomeActivity, {
            if (!it) {
                LoginActivity.launch(this@HomeActivity)
                finish()
            }
        })

        homeViewModel.postsLiveData.observe(this@HomeActivity, {
            Log.d("hilt-sandbox", "Posts: $it")
        })

        homeViewModel.fetchPosts()
    }
}
