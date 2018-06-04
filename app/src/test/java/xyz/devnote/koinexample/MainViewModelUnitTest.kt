package xyz.devnote.koinexample

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.closeKoin
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import xyz.devnote.koinexample.manager.FakeHttpManager
import xyz.devnote.koinexample.manager.Repository

class MainViewModelUnitTest : KoinTest {

    private val mainViewModel: MainViewModel by inject()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun before() {
        startKoin(listOf(modules))
    }

    @After
    fun after() {
        closeKoin()
    }

    @Test
    fun testGetUserDetailShouldSucess() {
        mainViewModel.getUserDetail()

        assert(mainViewModel.whenUserDetailLoaded.value == "getUserDetail")
    }

    @Test
    fun testGetUserDetailShouldFail() {
        mainViewModel.getUserDetail()

        assert(mainViewModel.whenUserDetailLoaded.value != "getUserDetaill")
    }

    private val modules: Module = applicationContext {
        bean { FakeHttpManager() as Repository }
        viewModel { MainViewModel(get()) }
    }
}