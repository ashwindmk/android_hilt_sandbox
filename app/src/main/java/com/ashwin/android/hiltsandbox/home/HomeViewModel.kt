package com.ashwin.android.hiltsandbox.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashwin.android.hiltsandbox.data.AuthService
import com.ashwin.android.hiltsandbox.data.Post
import com.ashwin.android.hiltsandbox.data.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authService: AuthService,
    private val postRepository: PostRepository
) : ViewModel() {
    private val _postsLiveData = MutableLiveData<List<Post>>()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    val loginStatusLiveData = MutableLiveData<Boolean>(true)

    fun logInstances() {
        Log.d("hilt-sandbox", "authService: $authService, postRepository: $postRepository")
    }

    fun logout() {
        authService.logout()
        loginStatusLiveData.postValue(false)
    }

    fun fetchPosts() {
        val posts = postRepository.getPosts()
        _postsLiveData.postValue(posts)
    }
}
