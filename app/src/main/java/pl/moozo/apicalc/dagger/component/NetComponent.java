package pl.moozo.apicalc.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import pl.moozo.apicalc.MainActivity;
import pl.moozo.apicalc.dagger.module.AppModule;
import pl.moozo.apicalc.dagger.module.NetModule;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
