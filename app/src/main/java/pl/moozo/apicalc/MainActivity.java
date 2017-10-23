package pl.moozo.apicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.moozo.apicalc.data.remote.APIService;
import pl.moozo.apicalc.data.remote.ApiUtils;

public class MainActivity extends AppCompatActivity {

    private TextView responseTv;
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sendBtn = (Button) findViewById(R.id.sendBtn);

        apiService = ApiUtils.getAPIService();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.sum(6, 7);
            }
        });
    }
}
