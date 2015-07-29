package io.c0nnector.github.sampleapp.modules;

import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.c0nnector.github.sampleapp.application.Application;
import timber.log.Timber;

@Module(
        includes = ApiModule.class,

        complete = false,
        library = true
)
public class DataModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    @Named("prettyGson")
    Gson providePrettyGson(){
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @Provides
    @Singleton
    Picasso providesPicasso(Application app, OkHttpClient client){

        return new Picasso.Builder(app)

                .downloader(new OkHttpDownloader(client))

                .listener(new Picasso.Listener() {

                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {

                        Timber.e(exception, "Failed to load image: %s", uri);
                    }
                })
                .build();
    }
}
