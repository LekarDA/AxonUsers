package com.example.axonusers.repository

import com.example.axonusers.data.Results

interface Repository {
    suspend fun getUsersList():List<Results>
}