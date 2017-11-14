package pl.moozo.apicalc.data.remote;

import io.reactivex.Observable;
import pl.moozo.apicalc.data.model.PostSum;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("/operations/sum")
    Observable<String> sum(@Body PostSum postSum);
}
