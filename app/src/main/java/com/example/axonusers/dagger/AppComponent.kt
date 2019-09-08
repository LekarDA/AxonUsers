package com.example.axonusers.dagger

import com.example.axonusers.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface AppComponent {
    fun injectActivity(activity: MainActivity)
}