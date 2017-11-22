package pl.moozo.apicalc;

import android.app.Application;

import pl.moozo.apicalc.dagger.component.DaggerNetComponent;
import pl.moozo.apicalc.dagger.component.NetComponent;
import pl.moozo.apicalc.dagger.module.AppModule;
import pl.moozo.apicalc.dagger.module.NetModule;

public class App extends Application{

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://192.168.0.100:8080/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

}
