package xyz.devnote.koinexample

import android.app.Application
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import xyz.devnote.koinexample.manager.HttpManager
import xyz.devnote.koinexample.manager.Repository

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(modules))
    }

    private val modules : Module = applicationContext {
        bean { HttpManager() as Repository }
        viewModel { MainViewModel(get()) }
    }
}