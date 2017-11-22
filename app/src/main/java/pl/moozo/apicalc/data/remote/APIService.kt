package pl.moozo.apicalc.data.remote

import io.reactivex.Single
import pl.moozo.apicalc.data.model.PostSum
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("/operations/sum")
    fun sum(@Body postSum: PostSum): Single<String>
}
