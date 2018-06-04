package xyz.devnote.koinexample

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.inject
import xyz.devnote.koinexample.manager.Repository

class MainActivity : AppCompatActivity() {

    private val repo : Repository by inject()
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelListener()

        viewModel.getUserDetail()
        viewModel.getNews()
    }

    private fun viewModelListener() {
        viewModel.whenUserDetailLoaded.observe(this, Observer {
            text.append(it)
        })

        viewModel.whenNewsLoaded.observe(this, Observer {
            text.append(it)
        })
    }
}
