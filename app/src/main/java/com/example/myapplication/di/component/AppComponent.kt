package com.example.myapplication.di.component

import android.app.Application
import com.example.myapplication.MainActivity
import com.example.myapplication.MainActivityViewModel
import com.example.myapplication.MyApp
import com.example.myapplication.di.module.AppModule
import com.example.myapplication.di.module.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class]
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApp: MyApp)
}