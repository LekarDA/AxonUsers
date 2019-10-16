package com.example.axonusers.repository

import androidx.lifecycle.MutableLiveData
import com.example.axonusers.data.Results
import com.example.axonusers.network_service.NetworkService
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val networkService : NetworkService):Repository {

    override suspend fun getUsersList(): ArrayList<Results> {
        val user = networkService.getUsers(2,20)
        return user.results!!
    }

}