package io.c0nnector.github.sampleapp.application;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import javax.inject.Inject;

import dagger.ObjectGraph;
import io.c0nnector.github.sampleapp.modules.AppModule;
import io.c0nnector.github.sampleapp.modules.Modules;

/**
 * Application class
 */
public class Application extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        //dagger
        setupDagger(Modules.list(this));
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
