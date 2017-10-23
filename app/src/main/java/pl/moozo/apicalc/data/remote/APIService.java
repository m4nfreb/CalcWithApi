package pl.moozo.apicalc.data.remote;


import pl.moozo.apicalc.data.model.PostSum;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/operations/sum")
    @FormUrlEncoded
    Call<PostSum> sum(@Field("num1") long num1,
                      @Field("num2") long num2);
}
