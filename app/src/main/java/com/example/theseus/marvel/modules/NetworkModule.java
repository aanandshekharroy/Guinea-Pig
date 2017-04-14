package com.example.theseus.marvel.modules;

import java.io.File;
import java.util.Timer;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by theseus on 14/4/17.
 */
@Module
public class NetworkModule {
    @Provides
    public OkHttpClient getOkHttpClient(HttpLoggingInterceptor interceptor, Cache cache){
        return new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }
    @Provides
    public Cache getCache(){
        File cacheFile=new File("okhttp-cache");
        cacheFile.mkdirs();
        int cacheSize=10*1024*1024;
        return new Cache(cacheFile, cacheSize);
    }
    @Provides
    public HttpLoggingInterceptor getInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.tag("OkHttp").d(message);
            }
        });
    }
}
