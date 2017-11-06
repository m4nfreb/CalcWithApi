package pl.moozo.apicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.moozo.apicalc.data.model.PostSum;
import pl.moozo.apicalc.data.remote.APIService;
import pl.moozo.apicalc.data.remote.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView responseTv;
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sendBtn = (Button) findViewById(R.id.sendBtn);
        responseTv = (TextView) findViewById(R.id.result);

        apiService = ApiUtils.getAPIService();

        sendBtn.setOnClickListener(view -> postSum(6, 7));
    }

    public void postSum(long a, long b){
        apiService.sum(new PostSum(a, b)).enqueue(new Callback<PostSum>() {
            @Override
            public void onResponse(Call<PostSum> call, Response<PostSum> response) {
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i("TAG", "post submitted to API." + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<PostSum> call, Throwable t) {
                Log.e("TAG", "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {
        if(responseTv.getVisibility() == View.GONE){
            responseTv.setVisibility(View.VISIBLE);
        }
        responseTv.setText(response);
    }
}
