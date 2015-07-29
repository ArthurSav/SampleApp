package io.c0nnector.github.sampleapp.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.c0nnector.github.sampleapp.MainActivity;
import io.c0nnector.github.sampleapp.application.Application;

@Module(
        injects = {
                Application.class,
                MainActivity.class
        }
)
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return application;
    }
}
