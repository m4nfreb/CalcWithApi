package pl.moozo.apicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pl.moozo.apicalc.data.model.PostSum;
import pl.moozo.apicalc.data.remote.APIService;
import pl.moozo.apicalc.data.remote.ApiUtils;

public class MainActivity extends AppCompatActivity {

    private TextView responseTv;
    private APIService apiService;
    private Button sendBtn;
    private long x = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.sendBtn);
        responseTv = (TextView) findViewById(R.id.result);

        apiService = ApiUtils.getAPIService();
        sendBtn.setOnClickListener(view -> postSum(x, 7));
    }

    public void postSum(long a, long b) {
        apiService.sum(new PostSum(a, b))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ ->  sendBtn.setEnabled(false))
                .doFinally(() -> sendBtn.setEnabled(true))
                .subscribe(
                        s -> {
                            showResponse(s);
                            Log.i("TAG", "post submitted to API. Response: " + s);
                            x++;
                        },
                        e -> {
                            String msg = "Unable to submit post to API. " + e.getMessage();
                            showResponse(msg);
                            Log.e("TAG", msg);
                        });
    }

    public void showResponse(String response) {
        if(responseTv.getVisibility() == View.GONE){
            responseTv.setVisibility(View.VISIBLE);
        }
        responseTv.setText(response);
    }
}
