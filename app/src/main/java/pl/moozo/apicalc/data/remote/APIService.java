package pl.moozo.apicalc.data.remote;


import pl.moozo.apicalc.data.model.PostSum;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("/operations/sum")
    Call<PostSum> sum(@Body PostSum postSum);
}
