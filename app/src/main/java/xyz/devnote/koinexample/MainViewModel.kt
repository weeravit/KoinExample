package xyz.devnote.koinexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import xyz.devnote.koinexample.manager.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    val whenUserDetailLoaded = MutableLiveData<String>()
    val whenNewsLoaded = MutableLiveData<String>()

    fun getUserDetail() {
        repository.getUserDetail { isError, data ->
            whenUserDetailLoaded.postValue(data)
        }
    }

    fun getNews() {
        repository.getNews { isError, data ->
            whenNewsLoaded.postValue(data)
        }
    }
}