package io.c0nnector.github.sampleapp.modules;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.c0nnector.github.sampleapp.api.ApiRequestInterceptor;
import io.c0nnector.github.sampleapp.api.MyApiService;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import static java.util.concurrent.TimeUnit.SECONDS;

@Module(
        complete = false,
        library = true
)
public class ApiModule {

    public static final String PRODUCTION_API_URL = "";

    @Provides
    @Singleton
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(PRODUCTION_API_URL);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return createOkHttpClient();
    }

    @Provides
    @Singleton
    ApiRequestInterceptor providerequestInterceptor() {
        return new ApiRequestInterceptor();
    }

    @Provides
    @Singleton
    RestAdapter providesRestAdapter(OkHttpClient okHttpClient, Endpoint endpoint, ApiRequestInterceptor interceptor, Gson gson) {

        return new RestAdapter.Builder()

                .setClient(new OkClient(okHttpClient))

                .setEndpoint(endpoint)

                .setConverter(new GsonConverter(gson))

                .setRequestInterceptor(interceptor)

                .build();
    }

    @Provides
    @Singleton
    MyApiService provideMyApiService(RestAdapter restAdapter) {
        return restAdapter.create(MyApiService.class);
    }


    /**
     * Creates an http client for our api
     *
     * @return
     */
    static OkHttpClient createOkHttpClient() {

        OkHttpClient client = new OkHttpClient();

        client.setConnectTimeout(10, SECONDS);
        client.setReadTimeout(10, SECONDS);
        client.setWriteTimeout(10, SECONDS);

        return client;
    }
}
