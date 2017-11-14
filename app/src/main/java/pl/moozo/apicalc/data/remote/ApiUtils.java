package pl.moozo.apicalc.data.remote;

public class ApiUtils {

    private ApiUtils() {}
    public static final String BASE_URL = "http://192.168.0.100:8080/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
