package xyz.devnote.koinexample.manager

class HttpManager : Repository {
    override fun getUserDetail(callback: (isError: Boolean, data: String) -> Unit) {
        callback(false, "getUserDetail")
    }

    override fun getNews(callback: (isError: Boolean, data: String) -> Unit) {
        callback(false, "getNews")
    }
}