package com.example.axonusers.dagger

import android.app.Application
import com.example.axonusers.network_service.NetworkService
import com.example.axonusers.presentor.ListPresenter
import com.example.axonusers.presentor.ListPresenterContract
import com.example.axonusers.repository.Repository
import com.example.axonusers.repository.RepositoryImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule(private val application: Application) {


    @Provides
    fun providePresentor(repository: Repository): ListPresenterContract.ListPresenter =
        ListPresenter(repository)


    @Provides
    @Singleton
    fun provideRepository(nbuApiService: NetworkService): Repository =
        RepositoryImplementation(nbuApiService)


    @Provides
    fun provideNetworkUtils(): NetworkService = NetworkService.create()
}