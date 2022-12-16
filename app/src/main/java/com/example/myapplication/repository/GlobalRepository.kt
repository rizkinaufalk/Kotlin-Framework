package com.example.myapplication.repository

import com.example.myapplication.AppExecutors
import com.example.myapplication.api.ApiService
import javax.inject.Inject

class GlobalRepository
@Inject constructor(
    private val appExecutors: AppExecutors,
    private val apiService: ApiService
){
}