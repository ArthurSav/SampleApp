package io.c0nnector.github.sampleapp.application;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import javax.inject.Inject;

import dagger.ObjectGraph;
import io.c0nnector.github.sampleapp.BuildConfig;
import io.c0nnector.github.sampleapp.modules.AppModule;
import io.c0nnector.github.sampleapp.modules.Modules;
import timber.log.Timber;

/**
 * Application class
 */
public class Application extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        setupLogging();

        //dagger
        setupDagger(Modules.list(this));
    }

    /*****************************************************
     * ---------------- * Logging * --------------------
     *
     *
     *
     ****************************************************/

    private void setupLogging(){

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    /*****************************************************
     * ---------------- * Dagger * --------------------
     *
     *
     *
     ****************************************************/

    public static void inject(Activity activity) {
        get(activity).getObjectGraph().inject(activity);
    }

    public static void inject(Fragment fragment){
        get(fragment.getActivity()).getObjectGraph().inject(fragment);
    }


    /*****************************************************
     * ---------------- * Helpers * --------------------
     *
     *
     *
     ****************************************************/

    public static Application get(Context context){
        return (Application) context.getApplicationContext();
    }
}
