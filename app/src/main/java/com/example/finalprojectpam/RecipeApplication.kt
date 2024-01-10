package com.example.finalprojectpam

import android.app.Application
import com.example.finalprojectpam.repository.AppContainer
import com.example.finalprojectpam.repository.RecipeContainerDataApp

class RecipeApplication : Application(){
    lateinit var container: AppContainer
    override fun onCreate(){
        super.onCreate()
        container = RecipeContainerDataApp(this)
    }
}