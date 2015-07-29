package io.c0nnector.github.sampleapp.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Global activity lifecycle callbacks
 */
public interface AppLifecycleCallbacks extends Application.ActivityLifecycleCallbacks {

    Application.ActivityLifecycleCallbacks MAIN = new AppLifecycleCallbacks() {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    };

}
