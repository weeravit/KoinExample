package xyz.devnote.koinexample.manager

interface Repository {
    fun getUserDetail(callback : (isError : Boolean, data : String) -> Unit)
    fun getNews(callback : (isError : Boolean, data : String) -> Unit)
}