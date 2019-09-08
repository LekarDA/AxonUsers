package com.example.axonusers

import android.app.Application
import com.example.axonusers.dagger.AppComponent
import com.example.axonusers.dagger.DaggerAppComponent
import com.example.axonusers.dagger.MainModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .mainModule(MainModule(this))
            .build()
    }

    companion object{
        lateinit var component: AppComponent
    }
}