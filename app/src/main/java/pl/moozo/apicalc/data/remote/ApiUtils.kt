package pl.moozo.apicalc.data.remote

object ApiUtils {
    val BASE_URL = "http://192.168.0.100:8080/"

    val apiService: APIService
        get() = RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)
}
